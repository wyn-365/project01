package com.wang.web;

import com.wang.domain.Account;
import com.wang.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void testFindAll(){

        //1、获取容器、
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //得到对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        //执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne(){

    }

    @Test
    public void testSave(){

    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){

    }

}
