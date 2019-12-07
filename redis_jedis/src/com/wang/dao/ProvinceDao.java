package com.wang.dao;

import com.wang.domin.Province;

import java.util.List;

public interface ProvinceDao {

    //查询所有，返回一个list集合
    public List<Province> findAll();
}
