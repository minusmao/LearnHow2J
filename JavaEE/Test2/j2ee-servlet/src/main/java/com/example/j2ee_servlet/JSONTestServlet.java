package com.example.j2ee_servlet;

import com.example.dao.Hero;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class JSONTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        String heroJSONStr = new String(request.getParameter("hero").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("接收到的数据：" + heroJSONStr);

        // 解析 JSON
        JSONObject heroJSON = new JSONObject(heroJSONStr);
        Hero hero = new Hero();
        hero.setName(heroJSON.getString("name"));
        hero.setHp(heroJSON.getInt("hp"));
        System.out.println("解析到 Hero 对象中：" + hero.toString());

        // 设置返回 JSON
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("name", hero.getName() + "-result");
        resultJSON.put("hp", hero.getHp() + 1);

        // 设置响应报文头信息
        response.setContentType("text/json;charset=UTF-8");

        // 获得输出流输出响应报文体
        PrintWriter out = response.getWriter();
        out.write(resultJSON.toString());
        System.out.println("服务端发送的数据" + resultJSON.toString());
    }
}
