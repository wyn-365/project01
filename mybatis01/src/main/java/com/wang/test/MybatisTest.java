package com.wang.test;

import com.wang.dao.UserDao;
import com.wang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *入门案例，没有写dao的实现类
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {

        //1、读取配置文件
        InputStream in = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2、创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3、使用工厂生产一个SqlSession对象
        SqlSession session = factory.openSession();

        //4、使用SqlSesssion创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);/*生产代理对象*/
        //5、使用代理对象执行方法
        List<User> users=  userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //6、释放资源
        session.close();
        in.close();
    }
}
