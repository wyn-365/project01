package com.wang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除一条记录
 */
public class JdbcDemo04 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            //1 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///news", "root", "123456");
            //3 定义SQL
            String sql = "delete  from account   where id = 3";
            //4 获取执行对象
            stmt = conn.createStatement();
            //5 执行sql
            int count = stmt.executeUpdate(sql);
            //6 处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            //释放资源
            //防止空指针异常
            if(stmt != null ){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
