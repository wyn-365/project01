package com.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet 的方法
 */
public class ServletDemo02 implements Servlet {

    //初始化方法 servlet创建时候执行，只会被执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service方法，执行多次，每一次都会被执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁方法，servlet被杀死时候执行，服务器正常关闭时候，会被执行
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
