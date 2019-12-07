package com.web.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.domain.Person;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java 对象转换为 json字符串
 */
public class JacksonTest {



    @Test
    public void test1() throws Exception {

        //创建对象
        Person p =new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建json的核心对象
        ObjectMapper mapper = new ObjectMapper();

        //调用方法转换
        String json = mapper.writeValueAsString(p);
        /*System.out.println(json);*/

        //将数据写到磁盘上
        /*mapper.writeValue(new File("d://a.txt"),p);*/



    }

    /**
     * list集合的转换
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        //创建对象
        Person p =new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        Person p1 =new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");

        Person p2 =new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");

        //创建一个list集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);



        //创建json的核心对象
        ObjectMapper mapper = new ObjectMapper();

        //调用方法转换
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);

        //将数据写到磁盘上
        /*mapper.writeValue(new File("d://a.txt"),p);*/
    }


    /**
     * Map集合的转换
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {

        Map<String,Object> map = new  HashMap<String,Object>();
        map.put("name","王一宁");
        map.put("age",23);
        map.put("gender","男");

        //创建json的核心对象
        ObjectMapper mapper = new ObjectMapper();

        //调用方法转换
        String json = mapper.writeValueAsString(map);
        System.out.println(json);

        //将数据写到磁盘上
        /*mapper.writeValue(new File("d://a.txt"),p);*/
    }
}
