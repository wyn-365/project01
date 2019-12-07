package com.wang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc连接
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //导入驱动jar包
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "123456");
       //定义sql
        String sql = "update fz_pmember set question=500 where id = 19";
        //获取执行对象
        Statement stmt = conn.createStatement();
        //执行sql
        int count = stmt.executeUpdate(sql);

        System.out.println(count);
        System.out.println("数据库已经连接成功，并且更新了数据");

        //释放资源
        stmt.close();
        conn.close();


    }
}
