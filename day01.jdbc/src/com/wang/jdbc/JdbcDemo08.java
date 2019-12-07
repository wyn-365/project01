package com.wang.jdbc;
/**
 * 演示jdbc工具类
 */

import com.wang.model.News;
import com.wang.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo08 {
    public static void main(String[] args) {
        List<News> list = new JdbcDemoNews07().findAll();
        System.out.println(list);
    }


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    List<News> list = null;


    //查询左右的News对象
    public List<News> findAll2(){
        // 1、注册驱动，可以写可以不写，建议写
        try {
            /*// 1、注册驱动，可以写可以不写，建议写
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///news", "root", "123456");*/
            //定义sql
            conn = JdbcUtils.getConnection();
            String sql = "select * from fz_news";
            //获取执行的对象
            stmt = conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //遍历结果集，封装对象，装载集合
            News news = null;
            list = new ArrayList<News>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String fenlei = rs.getString("fenlei");
                String content = rs.getString("content");
                String addtime = rs.getString("addtime");
                int visit = rs.getInt("visit");
                String quanxian = rs.getString("quanxian");
                //创建对象
                news = new News();
                news.setId(id);
                news.setTitle(title);
                news.setFenlei(fenlei);
                news.setContent(content);
                news.setAddtime(addtime);
                news.setVisit(visit);
                news.setQuanxian(quanxian);

                //装载集合
                list.add(news);

            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            /*if (rs != null){
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
            }*/

            JdbcUtils.close(rs,stmt,conn);
        }


        return list;
    }
}
