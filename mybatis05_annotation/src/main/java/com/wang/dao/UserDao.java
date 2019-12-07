package com.wang.dao;

import com.wang.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * crud四个注解
 */
public interface UserDao {

    //查询所有的用户
    @Select("select * from user")
    List<User> findAll();

    //保存用户信息
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    //更新用户
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id = #{id}")
    void updateUser(User user);

    //删除用户
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer userId);

    //根据ID查询
    @Select("select * from user where id = #{id}")
    User findById(Integer userId);

    //根据用户名称模糊查询
    @Select("select * from user  where username like #{username}")
    List<User> findUserByName(String username);

    //返回查询个数
    @Select("select count(*) from user")
    int fingTotalUser();
}
