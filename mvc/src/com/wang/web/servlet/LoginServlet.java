package com.wang.web.servlet;



import com.wang.domain.User;
import com.wang.service.UserService;
import com.wang.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获取提交来的验证码 根据name属性
        String verifycode = request.getParameter("verifycode");

        //2.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //确保验证码一次性
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //2.1验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //2.2跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }

        //3.封装User对象 用户名和密码
        Map<String, String[]> map = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        //5.判断是否登录成功
        if(loginUser != null){
            //登录成功

            //将用户存入session
            session.setAttribute("user",loginUser);
            //跳转页面 因为没有共享数据，采用重定向   虚拟目录+资源路径
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
