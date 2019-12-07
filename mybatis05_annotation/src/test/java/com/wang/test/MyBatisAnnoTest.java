package com.wang.test;
import com.wang.dao.UserDao;
import com.wang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisAnnoTest {
    /**
     * 测试注解的使用
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1、获取字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、共建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3、生产sqlsession
        SqlSession session = factory.openSession();
        //4、获取dao的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.执行方法
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6、释放资源
        session.commit();
        is.close();

    }
}
