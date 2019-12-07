package com.wang.service;

import com.wang.domin.Province;

import java.util.List;

public interface ProvinceService {

    //查询所有，返回一个list集合
    public List<Province> findAll();

    public String findAllJson();
}
