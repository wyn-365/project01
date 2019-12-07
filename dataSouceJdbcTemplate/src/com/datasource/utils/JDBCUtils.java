package com.datasource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid连接池的工具类
 */
public class JDBCUtils {
    //定义成员变量
    private static DataSource ds;

    static {

        try {
            // 1、加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 2 、获取DataSource
            try {
                ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接的方法
     *
     */
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    /**
     * 释放资源的方法
     *
     */

    public static void close(ResultSet rs,Statement stmt, Connection conn){


        if(rs!=null){
            try {
                rs.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt,Connection conn){

        if(stmt!=null){
            try {
                stmt.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池的方法
     *
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
