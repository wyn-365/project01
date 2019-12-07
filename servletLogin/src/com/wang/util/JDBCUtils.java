package com.wang.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc的工具类，使用的durid连接池
 *
 */
public class JDBCUtils {
    private static DataSource ds;

    static {

        try {
            //1加载配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //初始化连接池
    }

    //获取连接吃对象
    public static DataSource getDataSource(){
        return ds;
    }

    //获取连接connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
