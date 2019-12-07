package com.wang.dao;

import com.wang.domain.Clazz;

public interface ClazzMapper {

    //根据id查询班级信息
    Clazz selectClazzById(Integer id);
}
