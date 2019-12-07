package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 配置拦截器的访问方式
 */
/**
默认值是request，浏览器请求才会被拦截器拦截
 */
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

/**
FORWARD 资源只有转发 才会被拦截
 */
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

/**
 * 无论是浏览器直接访问资源，还是服务器转发资源都会被拦截
 */

@WebFilter(value="/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})



public class FilterDemo05 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo05....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
