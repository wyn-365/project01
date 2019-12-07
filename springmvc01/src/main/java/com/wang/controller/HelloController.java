package com.wang.controller;

//控制器的类 用接受请求

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user") /*第一级请求路径，并且可以省略！！！！和servlet的注解类似*/
public class HelloController {

    @RequestMapping(path="/hello")  /*第二级请求路径*/
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }


    /**
     * RequestMapping  既可以加载在方法上，又可以加载在类上
     * @return
     *
     * RequestMethod.POST 只接受post的提交费那事，不接受超链接
     */
    @RequestMapping(path="/testRequestMapping",method = RequestMethod.POST)

    public String testRequestMapping(){
        System.out.println("测试requestMapping注解");
        return "success";
    }

}
