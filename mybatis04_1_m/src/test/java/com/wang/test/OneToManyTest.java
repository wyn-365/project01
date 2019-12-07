package com.wang.test;

import com.wang.dao.ClazzMapper;
import com.wang.dao.UserDao;
import com.wang.domain.Clazz;
import com.wang.domain.Student;
import com.wang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/*测试crud
*
*
* */
public class OneToManyTest {
    private InputStream in;
    private SqlSession sqlSession;
    private ClazzMapper clazzMapper;

    @Before//用户在单元测试之前执行
    public void init()throws Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获取对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        //3.获取Sqlsession对象
        sqlSession = factory.openSession();

        //4.获取dao的代理对象
        clazzMapper = sqlSession.getMapper(ClazzMapper.class);
    }

    @After//用户在测试单元之后执行
    public  void destory() throws Exception{

        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }


    //查询所有
    @Test
    public void testFinById(){
        Clazz clazz = clazzMapper.selectClazzById(1);
        System.out.println(clazz.getId()+" "+ clazz.getCode() + " "+ clazz.getName());
       //查循关联的学生信息
        List<Student> students = clazz.getStudents();

        for (Student student :students){
            System.out.println(student);
        }

        }



}
