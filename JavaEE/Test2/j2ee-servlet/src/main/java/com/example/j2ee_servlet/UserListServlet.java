package com.example.j2ee_servlet;

import com.example.dao.User;
import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name = "UserListServlet", value = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得请求的参数
        int begin = Integer.parseInt(request.getParameter("begin"));
        int length = Integer.parseInt(request.getParameter("length"));

        // 查询数据库
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.selectAllUsers(begin, length);

        // 格式化 HTML
        StringBuffer html = new StringBuffer();
        html.append("<html><body><table border='1px'>");
        html.append("<tr> <th>id</th> <th>name</th> <th>password</th> <th>sex</th> <th>country</th> <th>signature</th> </tr>");
        for (User user : userList) {
            String tr = "<tr> <td>%d</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>";
            String trFormat = String.format(tr, user.getId(), user.getName(), user.getPassword(), user.getSex().getName(), user.getCountry(), user.getSignature());
            html.append(trFormat);
        }
        html.append("</table></body></html>");

        // 设置响应报文
        response.setContentType("text/html;charset=UTF-8");

        // 输出 HTML
        PrintWriter out = response.getWriter();
        out.println(html);
    }
}
