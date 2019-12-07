package com.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0连接池参数验证
 */
public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
        // 1、获取DataSource 【这是默认配置】
        DataSource ds = new ComboPooledDataSource();

        //指定名称配置
        //DataSource ds = new ComboPooledDataSource("otherc3p0");
        //2、获取连接数量 10次? 3s后报错若11个连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }

    }
}
