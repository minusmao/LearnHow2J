package com.example.j2ee_servlet;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@MultipartConfig    // 使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * How2J 网站上的过时，参考其他博文：
         * servlet3.0版本以前需要使用第三方的jar包commons-fileupload来实现上传文件，servlet3.0版本自带了上传文件的api，无需第三方jar包
         * servlet3.0将上传的文件保存在Part实例中，可以通过request对象根据上传的表单控件的name获取对应的part对象，同时也支持多个文件上传
         * 原文链接：https://blog.csdn.net/a3226988/article/details/82685094
         */
        System.out.println("getPart");
        // 获取请求报文提交的数据
        //String name = request.getParameter("name");
        Part uploadPart = request.getPart("upload-file");
        // 生成文件名：UUID + name
        String fileName = UUID.randomUUID() + ".png";    // randomUUID() 随机 32 位字符串
        String filePath = "F:/upload/";
        // 获取上传文件的输入流
        try {
            File uploadFile = new File(filePath + fileName);
            System.out.println("try");
            InputStream in = uploadPart.getInputStream();

            System.out.println("getInputStream()");
            // 本地磁盘输出流
            FileOutputStream fileOut = new FileOutputStream(uploadFile);
            System.out.println("FileOutputStream()");
            // 复制
            byte[] bytes = new byte[1024];
            int length;
            while ((length = in.read(bytes)) != -1) {
                fileOut.write(bytes, 0, length);
                System.out.println("ok");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 跳转
        response.sendRedirect("login-success.html");
    }
}
