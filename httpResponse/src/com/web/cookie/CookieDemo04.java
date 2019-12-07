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
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
        Cookie c = new Cookie("msg","hello cookie");

        //设置cookie的存活时间
        c.setMaxAge(30);//cookie持久化到硬盘，30秒后自动删除cookie文件
        /*c.setMaxAge(-1);//默认值，浏览器关闭 自动删除
        c.setMaxAge(0);//删除cookie*/

        //tomcat8之前不能直接存储中文，之后支持中文数据 ，不会有任何问题
        //发送cookie对象
        response.addCookie(c);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
