package com.wang.jdbc;

import java.sql.*;

public class JdbcDemo06 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///news", "root", "123456");
            //3 定义SQL
            String sql = "select *  from account   ";
            //4 获取执行对象
            stmt = conn.createStatement();
            //5 执行sql
            rs = stmt.executeQuery(sql);
            //6 处理结果
            //6.1 光标向下一动一行
            //循环判断，光标是否为最后一行末尾
            while(rs.next()){

                //获取数据
                int id = rs.getInt(1);

                String name = rs.getString("Name");

                int salary = rs.getInt(3);

                System.out.println(id+"--"+name+"--"+salary);
            }
            /*if(rs.next()){
                //获取数据
                int id = rs.getInt(1);

                String name = rs.getString("Name");

                int salary = rs.getInt(3);

                System.out.println(id+"--"+name+"--"+salary);

            }
*/


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            //释放资源
            //防止空指针异常
            if(rs != null ){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
