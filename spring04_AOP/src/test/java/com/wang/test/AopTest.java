package com.wang.test;


import com.wang.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP
 */
public class AopTest {
    public static void main(String[] args) {

        //1、获取IOC容器对象】
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、获取对象】
        AccountService as =(AccountService)ac.getBean("accountService");

        //3.执行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
