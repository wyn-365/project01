package com.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示request 获取请求行数据
 */
@WebServlet("/RequestDemo01")
public class RequestDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);

        //获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //获取请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //获取url
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        //获取协议版本
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //获取客户的IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
