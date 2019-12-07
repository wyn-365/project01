package com.wang.test;

import com.wang.dao.UserDao;
import com.wang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {

    private InputStream is;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws Exception{
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(is);
         session = factory.openSession();
         userDao = session.getMapper(UserDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("言子美人");
        user.setAddress("保定市莲池区");
        user.setSex("女");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(51);
        user.setUsername("江山美人");
        user.setAddress("保定市美人区");
        user.setBirthday(new Date());
        user.setSex("女");

        userDao.updateUser(user);
    }


    @Test
    public void testDelete(){
        userDao.deleteUser(51);
    }


    @Test
    public void testSelectById(){

        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFinfByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }


    @Test
    public void testTotalCount(){
        int count = userDao.fingTotalUser();
        System.out.println(count);
    }
}
