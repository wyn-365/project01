package com.wang.jdbc;

import com.wang.utils.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 键入用户名和密码，判断用户是否登录成功
 */
public class JdbcDemo09Login {

    public static void main(String[] args) {
        //键盘录入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();

        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //调用方法
        boolean flag = new JdbcDemo09Login().login(username, password);
        //判断结果成功是否zz
        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或者密码错误");
        }
    }


    //登录方法

    /**
     * 使用preparedStatement 来实现  防止sql注入
     * 后期都会使用这个对象来完成增删改查的操作，防止sql注入，效率更高
     */
    public boolean login(String username,String password){
        if (username==null || password==null){
            return false;

        }
        //连接数据库，判断是否登录成功
        //获取连接

        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            //定义sql
            String sql = "select * from user where user=? and password = ? ";
            //获取执行sql对象zzz
            pstmt = conn.prepareStatement(sql);

            //给？赋值*******
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            //执行查询,不需要传递参数
            rs = pstmt.executeQuery();
            //判断
            return rs.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }

        return false;
    }
}
