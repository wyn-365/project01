package com.wang.test;

import com.wang.dao.UserDao;
import com.wang.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){

        User loginuser = new User();
        loginuser.setUsername("zz");
        loginuser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);

    }
}
