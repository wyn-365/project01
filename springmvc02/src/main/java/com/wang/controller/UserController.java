package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了");

        //模拟从数据库中查询出了数据
        User user = new User();
        user.setUsername("郭美美");
        user.setPassword("123456");
        user.setAge(30);

        //model 对象用来存数据
        model.addAttribute("user",user);
        return "success";
    }

    //返回值类型是void
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid");
        //利用请求转发
       /* request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);*/

        //重定向的方式
        /**
         * 重定向不可直接进入WEB-INF目录下
         * 但是请求转发是没有问题的
         */
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //直接进行响应
        response.getWriter().println("hello,你好");
        return;
    }



    /*
        ModelAndView
         */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView( ){

        //创建爱你ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView");

        //模拟从数据库中查询出了数据
        User user = new User();
        user.setUsername("郭美美");
        user.setPassword("123456");
        user.setAge(30);

        //user对象存入到mv对象中，也会把user对象存入到request域中
        mv.addObject("user",user);

        //跳转到那个页面
        mv.setViewName("success");

        return mv;
    }


    /**
     * 模拟异步的响应和输出Ajax  响应json数据
     */
    @RequestMapping("/testAjax")
    public @ResponseBody  User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        //客户端发送的是ajax请求，以json格式
        //后台已经吧json字符串封装到user对象中了
        System.out.println(user);

        //模拟查询数据库了
        user.setUsername("zeze");
        user.setPassword("123456");
        user.setAge(100);

        //作出响应
        return user;


    }
}
