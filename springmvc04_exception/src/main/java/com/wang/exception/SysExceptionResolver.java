package com.wang.exception;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器的类
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

       //处理异常的逻辑
        //获取异常的对象
        SysException e = null;
        if (ex instanceof SysException) {
            e = (SysException) ex;
        }else {
            e = new SysException("系统正在维护,,,...");
        }

        //创阿金modelandview对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
