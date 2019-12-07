package com.wang.utils;

/**
 * 用于记录日志的工具类
 */
public class Logger {

    /**
    用于打印日志。在切入点方法执行之前执行
     */
    public void printLog(){
        System.out.println("Logger类中的printLog开始记录日志了。。。");
    }
}
