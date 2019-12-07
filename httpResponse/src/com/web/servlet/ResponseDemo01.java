package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成重定向，访问responseDemo01，会跳转到responseDemo02
 */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1被访问了");
        //设置状态吗为302
        /*response.setStatus(302);
        //设置响应头
        response.setHeader("location","/httpResponse/responseDemo02");*/

        //简单的重定向方法，代替上面的
        response.sendRedirect("/httpResponse/responseDemo02");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
