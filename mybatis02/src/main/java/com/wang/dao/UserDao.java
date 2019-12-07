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

    //保存用户
    void saveUser(User user);

    //更新用户
    void updateUser(User user);

    //删除用户信息
    void deleteUser(Integer userId);

    //根据ID查询用户信息
    User findById(Integer userId);

    //模糊查询
    List<User> findByName(String username);

    //查询总的用户数量
    int findTotal();

}
