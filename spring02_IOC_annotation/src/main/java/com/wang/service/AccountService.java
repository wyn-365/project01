package com.wang.service;

import com.wang.domain.Account;

import java.util.List;

public interface AccountService {

    void saveAccount();

    List<Account> findAllAccount();

}
