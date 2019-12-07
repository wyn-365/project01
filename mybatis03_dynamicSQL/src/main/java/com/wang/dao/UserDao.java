package com.wang.dao;

import com.wang.domain.User;

import java.util.List;

/*
*
* 用户的持久层接口
* */
public interface UserDao {

    //查询所有的用户
    List<User> findAll();


    //根据ID查询用户信息
    User findById(Integer userId);

    //模糊查询
    List<User> findByName(String username);


    //根据传入的条件查询
    List<User> findUserByCondition(User user);

}
