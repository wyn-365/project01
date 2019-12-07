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

/*测试crud
*
*
* */
public class MybatisTest  {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用户在单元测试之前执行
    public void init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获取对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //3.获取Sqlsession对象
        sqlSession = factory.openSession();

        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用户在测试单元之后执行
    public  void destory() throws Exception{

        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() {

        //5.执行查询所有的方法
        List<User> users = userDao.findAll();

        for (User user: users){
            System.out.println(user);
        }


    }



    /**
     * 测试id查询用户操作
     */
    @Test
    public void testFindById() throws Exception{

        //查询一个用户
        User user = userDao.findById(41);
        System.out.println(user);
    }


    /**
     * 模糊用户操作
     */
    @Test
    public void testFindByName() throws Exception{

        //查询一个用户
        List<User> users = userDao.findByName("%王%");
        for(User user : users) {
            System.out.println(user);
        }
    }



    /**
     * 模糊用户操作
     */
    @Test
    public void testFindUserByCondition() throws Exception{
        User u = new User();
        u.setUsername("老王王");
        //查询一个用户
        List<User> users = userDao.findUserByCondition(u);
        for(User user : users) {
            System.out.println(user);
        }
    }



}
