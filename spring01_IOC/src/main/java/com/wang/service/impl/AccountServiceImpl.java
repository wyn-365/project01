package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.dao.impl.AccountDaoImpl;
import com.wang.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {


    //将产变化的数据，不使用注入的方法
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;

    }

    //构造函数
    public void saveAccount(){
        System.out.println("save方法执行了"+name+","+age+","+birthday);
    }
}
