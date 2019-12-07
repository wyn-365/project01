package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器，登录权限
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //获取资源请求路径
        String uri = request.getRequestURI();

        //判断是否是登录的资源，登录相关的直接放行
        /**
         * 注意排除 css js img 验证码资源
         */
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/")  || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            //证明用户就是登陆  放行
            chain.doFilter(req, resp);
        }else{
            //不是登录的操作，验证用户是否登陆
            //从session中获取user
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                //已经登陆了  放行
                chain.doFilter(req, resp);
            }else {
                //没有登陆，跳转登录页面
                request.setAttribute("login_msg","你没有登录，请先登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
