package com.wang.dao;

import com.wang.domain.Account;

import java.util.List;

public interface AccountDao {

    //查询所有
    List<Account> findAll();

    //查询所有账户，并且带有用户名和地址信息
    List<Account> findAllAccount();
}
