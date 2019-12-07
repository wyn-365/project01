package com.wang.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate 的基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        /**
         * 配置数据源 c3p0  druid  或者
           spring的内置数据源
         */
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mybatis01");
        ds.setUsername("root");
        ds.setPassword("123456");

        //创建JdbcTemplate对象 并设施数据源
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        //执行操作
        jt.execute("insert into account (id,name,money) values (4,'言子妹儿',1000)");
    }
}
