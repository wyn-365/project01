package com.datasource.druid;
/**
 * druid连接池对象的使用，需要收doing加载配置文件
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * druid的使用  阿里巴巴提供，国产，最优秀的连接池之一
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //1、导入jar包
        //2、自定义配置文件，【.properties形式】，可以任意名称，任意路径，因为需要手动配置 手动加载
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4、获取连接池对象 DruidDataSourceFactory
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //5 获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
