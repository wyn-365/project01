package com.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie 快速入门
 */
@WebServlet("/cookieDemo03")
public class CookieDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象 可以创建多个cookie
        Cookie c1 = new Cookie("msg","hello cookie");
        Cookie c2 = new Cookie("name","hello cookie1111");
        //发送cookie对象
        response.addCookie(c1);
        response.addCookie(c2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
