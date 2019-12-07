package com.wang.dao;

import com.wang.domain.User;
import com.wang.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中的user表的类 增删改查
 *
 */
public class UserDao {

    //声明一个jdbctemplate对象来公用
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());


    public User login(User loginUser){

       try { //编写sql
           String sql = "select * from user where username = ? and password = ?";
           //调用方法
           User user = template.queryForObject(sql,
                   new BeanPropertyRowMapper<User>(User.class),
                   loginUser.getUsername(), loginUser.getPassword());

           return user;
       }catch(DataAccessException e){  //登陆失败则返回null
           e.printStackTrace();//记录日志
           return null;
       }
    }
}
