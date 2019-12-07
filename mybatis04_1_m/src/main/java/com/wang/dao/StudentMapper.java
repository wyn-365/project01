package com.wang.dao;

import com.wang.domain.Student;

public interface StudentMapper {

    //根据id查询学生信息
    Student selectStudentById(Integer id);

}
