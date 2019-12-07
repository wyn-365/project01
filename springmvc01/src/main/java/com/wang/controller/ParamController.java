package com.wang.controller;

import com.wang.domain.Account;
import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了");
        System.out.println("您的用户名是："+ username);
        System.out.println("您的密码是："+ password);

        return "success";
    }


    /**
     * 获取到的请求参数，绑定到JavaBean中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){

        System.out.println(account);

        return "success";
    }

    //自定义类型转换器
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("类型转换成功了");
        System.out.println(user);

        return "success";
    }

}
