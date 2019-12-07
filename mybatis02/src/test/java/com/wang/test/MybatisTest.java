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
     * 测试保存操作
     */
    @Test
    public void testSave() throws Exception{
        User user = new User();
        user.setUsername("mybatis saveuser");
        user.setAddress("保定市莲池区");
        user.setSex("男");
        user.setBirthday(new Date());

        //5.执行保存用户的方法
        userDao.saveUser(user);
    }


    /**
     * 测试更新用户操作
     */
    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(50);
        user.setUsername("泽泽");
        user.setAddress("保定市莲池区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行保存用户的方法
        userDao.updateUser(user);
    }


    /**
     * 测试删除用户操作
     */
    @Test
    public void testDelete() throws Exception{

        //5.删除
        userDao.deleteUser(50);
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
     * 查询总计路条数
     */
    @Test
    public void testFindTotal() throws Exception{

        int count = userDao.findTotal();
        System.out.println(count);
    }



}
