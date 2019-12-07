package com.wang.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc 的工具类
 *
 */
public class JdbcUtils {
    /*
    文件的读取，只需要一次，使用静态代码块，只会执行一次
     */
    private  static String url;
    private  static String user;
    private  static String password;
    private  static String driver;

    static {
        //读取配置文件

        try {
            // 1、创建
            Properties pro = new Properties();
            // 2、加载文件

            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //System.out.println(path);

            pro.load(new FileReader(path));



            /*pro.load(new FileReader(""));*/
            //3、获取属性 赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //注册驱动
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取连接的方法
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    //释放资源的方法
    public static void close(Statement stmt,Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
