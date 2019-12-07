package com.wang.dao;

import com.wang.domain.User;

import java.util.List;

/*
*
* 用户的持久层接口
* */
public interface UserDao {

    //查询所有的用户，并获取用户的账户信息
    List<User> findAll();


    //根据ID查询用户信息
    User findById(Integer userId);

}
