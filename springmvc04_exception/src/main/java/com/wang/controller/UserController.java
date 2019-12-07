package com.wang.controller;

import com.wang.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException方法执行了");

        try {
            int a = 10/0;
        } catch (Exception e) {
            e.printStackTrace();

            //抛出自定义的异常信息
            throw new SysException("查询所有的用户出现错区。。。");
        }

        return "success";
    }
}
