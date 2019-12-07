package com.datasource.template;

import com.datasource.model.News;
import com.datasource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 修改  news 表   DML语句
 */
public class JdbcTemplateDemo02 {

    //Junit单元测试，可以让方法独立的执行，不依赖于主方法

    //1、获取jdbctemplate对象
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void  test1(){

        //2、定义sql
        String sql = "update news set visit=80 where id = 71";
        //3、执行sql
        int count = template.update(sql);
        System.out.println(count);

    }

    //news表中添加一条记录
    @Test
    public void  test2(){
        //2、定义sql
        String sql = "insert into news(title,fenlei,visit) values(?,?,?)";
        //执行sql
        int count = template.update(sql, "言子美人", "美女", 66);
        System.out.println(count);
    }

    //删除上面添加的记录
    @Test
    public void  test3(){
        //2、定义sql
        String sql = "delete from news where id = ?";
        //执行sql
        int count = template.update(sql, 85);
        System.out.println(count);
    }

    /**
     * 查询id为84 的记录，封装成为Map集合【只能是一条记录，结果集只能是1】
     * 多条记录要用queryForlist
     */
    @Test
    public void  test4(){
        //2、定义sql
        String sql = "select * from news where id = ?";
        //3、执行sql
        Map<String, Object> map = template.queryForMap(sql, 84);
        System.out.println(map);
    }

    /**
     * 查询所有的记录，封装为list集合
     * 每一条记录封装为map集合，再讲map集合在装载在list集合汇总
     */

    @Test
    public void  test5(){
        //2、定义sql
        String sql = "select * from news ";
        //3、执行sql
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }

    }

    /**
     * 查询多有的记录，封装为news对象【Javabean对象】的list集合
     */


    @Test
    public void  test6(){
        //2、定义sql
        String sql = "select * from news ";
        //3、执行sql
       List<News> list = template.query(sql,new RowMapper<News>(){

           @Override
           public News mapRow(ResultSet rs, int i) throws SQLException {
               News news = new News();
               int id = rs.getInt("id");
               String title = rs.getString("title");
               String fenlei = rs.getString("fenlei");
               String content = rs.getString("content");
               String adder = rs.getString("adder");
               int visit = rs.getInt("visit");
               String quanxian = rs.getString("quanxian");

               //获取出来，set进去
               news.setId(id);
               news.setTitle(title);
               news.setFenlei(fenlei);
               news.setContent(content);
               news.setAddtime(adder);
               news.setVisit(visit);
               news.setQuanxian(quanxian);
               return news;
           }
       });

        for (News news : list) {
            System.out.println(news);
        }

    }

    /**
     * 利用封装好的
     */


    @Test
    public void  test7(){
        //2、定义sql
        String sql = "select * from news ";
        //3、执行sql
        List<News> list = template.query(sql, new BeanPropertyRowMapper<News>(News.class));
        for (News news : list) {
            System.out.println(news);
        }

    }
}
