package com.wang.dao.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import com.wang.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("保存可账户");
    }
}
