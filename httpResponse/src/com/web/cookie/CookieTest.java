package com.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 判断是不是第一次登陆
 *   第一次： 欢迎首次访问
 *   第二次：欢迎回来，您上次登陆的时间为。。。。
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //响应消息体的格式和编码
        response.setContentType("text/html;charset=utf-8");

        //获取所有的cookie
        Cookie[] cookies = request.getCookies();
        //遍历数组
        if (cookies!=null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //获取所有的cookie名称
                String name = cookie.getName();
                //判断名称是否是lastTime
                if ("lastTime".equals(name)){
                    //有的话 不是第一次访问

                    //设置cookie的值
                    //获取的那个钱时间的字符串。重新设置发送
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    String str_date = sdf.format(date);
                    cookie.setValue(str_date);

                    //设置存活力时间
                    cookie.setMaxAge(60);//一个月

                    response.addCookie(cookie);
                    //响应数据
                    String value = cookie.getValue();
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为："+ value+"</h1>");

                    break;
                }

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
