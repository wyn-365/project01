package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.dao.impl.AccountDaoImpl;
import com.wang.domain.Account;
import com.wang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service(value = "accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao = null;
    //构造函数
    public void saveAccount(){
        accountDao.saveAccount();
    }

    public List<Account> findAllAccount() {
        return null;
    }
}
