package com.wang.jdbcTemplate;

import com.wang.dao.AccountDao;
import com.wang.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate 的基本用法
 */
public class JdbcTemplateAccount {
    public static void main(String[] args) {
        //1获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2持久层获取IOC中的Dao层的对象
        AccountDao accountDao = ac.getBean("accountDao",AccountDao.class);

        //3执行Dao中的根据ID查询用户的方法
        Account account = accountDao.finAccountById(1);
        System.out.println(account);

        account.setMoney(888.0);
        accountDao.updateAccount(account);
        System.out.println(account);


    }
}
