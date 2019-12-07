package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/requestParam")
public class RequestParamController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }


    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }


    /**
     * PathVariable的注解
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }



    /**
     * 获取请求头的值
     * RequestHeader
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了");
        System.out.println(header);
        return "success";
    }



    /**
     * 获取testCookieValue的值
     * RequestHeader
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * ModelAttribute 注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(@ModelAttribute(value = "zezeze") String uname, Map<String,User> map){
        //模拟查询数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("zezeze",user);

    }

    /**
     * 会优先执行，优先 优先
     */
    /*@ModelAttribute
    public User showUser(String uname){
        //模拟查询数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;

    }*/

    /**
     * SessionAttributes
     * @param
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        //存储到request域对象中
        model.addAttribute("msg","郭美美");
        System.out.println("testSessionAttributes");

        return "success";
    }


}
