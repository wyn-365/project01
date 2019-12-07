package com.wang.dao.impl;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;
import com.wang.dao.ProvinceDao;
import com.wang.domin.Province;
import com.wang.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1、声明一个成员变量 template
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Province> findAll() {

        //定义sql
        String sql = "select * from province";

        //执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
