package com.wang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * insert语句添加
 */
public class JdbcDemo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql
            String sql = "insert into account values(4,'泽泽',60)";
            //获取conn对象
            try {
                 conn = DriverManager.getConnection("jdbc:mysql:///news","root","123456");
                 stmt = conn.createStatement();
                //执行sql
                int count = stmt.executeUpdate(sql);
                //处理结果
                System.out.println(count);

                if(count > 0){
                    System.out.println("添加成功");
                }else{
                    System.out.println("添加失败");
                }
            //释放资源

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
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
