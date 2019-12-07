package com.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextMIME")
public class ContextMIME extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext对象的获取
        //获取出来的都是同一个

        //、通过HTTPservlet获取
        ServletContext context = this.getServletContext();

        //定义一个文件名称
        String filename ="a.jpg";//image/jpeg

        //获取MIME类型
        String mimeType = context.getMimeType(filename);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
