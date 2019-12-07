package com.wang.web;

import com.wang.dao.AccountDao;
import com.wang.service.AccountService;
import com.wang.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 获取spring容器IOC核心容器，并根据id获取对象
 *
 * 读取完配置文件，立马通过反射机制，创建对象【容器中又什么，采用立即加载的机制创建对象】
 * 而beanfactory采用延迟加载的机制，什么时候用，神魔时候创建对象
 */
public class Client {
    public static void main(String[] args) {

        //1.获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //2.根据id 获取bean对象[ 两种方式获取对象]
        //AccountService as = (AccountService)ac.getBean("accountService");

        //AccountService as = (AccountService)ac.getBean("accountService2");
        AccountService as = (AccountService)ac.getBean("accountService3");

        as.saveAccount();
    }
}
