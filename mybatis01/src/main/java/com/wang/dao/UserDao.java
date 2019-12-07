package com.wang.dao;

import com.wang.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    //查询所有的操作
    /**
     * 将对应的xml文件配置好，无需在写【实现类】，由mybatis完成
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
