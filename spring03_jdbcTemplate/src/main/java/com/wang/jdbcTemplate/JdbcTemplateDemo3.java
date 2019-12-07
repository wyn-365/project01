package com.wang.jdbcTemplate;

import com.wang.dao.AccountDao;
import com.wang.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * jdbcTemplate 的CRUD基本用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2获取jdbcTemplate对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);

        //执行操作
        //保存
        //jt.update("insert into account(id,name,money)values (?,?,?)",5,"zezeze",666.0);

        //更新
        //jt.update("update account set name=?,money=? where id =?","美人",3636.0,5);

        // 删除
        //jt.update("delete from account where id= ?",5);

        // 查询所有
        //jt.query("select * from account where money>?",new AccountRowMapper(),1000.0);
        // 查询一个
        //List<Account> accounts = jt.query("select * from account where id =?",new BeanPropertyRowMapper<Account>(Account.class),1);
        //System.out.println(accounts.isEmpty()?"没有查询到":accounts.get(0));
        // 返回一行一列（使用聚合函数 group by）
        Integer count = jt.queryForObject("select count(*) from account where money >?", Integer.class, 200.0);
        System.out.println(count);


    }
}
