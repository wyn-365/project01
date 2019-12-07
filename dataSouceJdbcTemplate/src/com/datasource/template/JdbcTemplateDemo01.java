package com.datasource.template;

import com.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的学习
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1、导入jar包
        //2、创建jdbctemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3、调用方法
        String sql = "update account set salary=3636 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);


    }
}
