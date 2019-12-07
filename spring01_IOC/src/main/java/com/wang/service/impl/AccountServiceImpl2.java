package com.wang.service.impl;

import com.wang.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {


    //将产变化的数据，不使用注入的方法
    private String name;
    private Integer age;
    private Date birthday;

    //生成set方法  为了注入数据
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //构造函数
    public void saveAccount(){
        System.out.println("save方法执行了"+name+","+age+","+birthday);
    }
}
