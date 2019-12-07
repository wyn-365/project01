package com.wang.dao;


import com.wang.domain.Account;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    //根据ID查询账户
    Account finAccountById(Integer accountId);
    //根据名称查询用户
    Account findAccountByName(String accountName);
    //更新账户
    void updateAccount(Account account);
}
