package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*@WebFilter("/*")//访问所有的资源之前，都会执行这个过滤器*/
public class FilterDemo01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo01被执行了。。。");

        //****非常重要的事情，要放行 是否通过
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
