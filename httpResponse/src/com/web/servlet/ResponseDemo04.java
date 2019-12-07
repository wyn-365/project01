package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取之前，设置编码、
        /*response.setCharacterEncoding("UTF-8");*/

        //高速浏览器解码方式
        response.setHeader("content-type","text/html;charset=utf-8");

        //1、获取字符输出流
        PrintWriter pw = response.getWriter();
        //2、输出数据
        //浏览器默认的是GBK【】GB2312中文码表
        //服务器用的编码的是Tomcat编码的，拉丁编码，ISO-8859-1
        //编码和解码不一样，所以会乱码
        pw.write("你好 response");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
