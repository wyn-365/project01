package com.wang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

   //预处理 在controller执行之前执行

    /**
     * return true :放行，执行下一个拦截器，如果没有的话，执行controller
     * return false :不放行，克制执行跳转到别的页面
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了");
        return true;
    }
}
