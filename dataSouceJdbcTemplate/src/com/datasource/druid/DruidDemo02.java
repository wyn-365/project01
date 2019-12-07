package com.datasource.druid;

import com.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用工具类
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        //完成一个添加的操作 account 添加记录
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1、获取连接
            conn = JDBCUtils.getConnection();
            //2、定义sql
            String sql = "insert into account values(3,?,?)";
            //3、获取pstmt 对象
            pstmt = conn.prepareStatement(sql);
            //4、给？赋值
            pstmt.setString(1,"美人");
            pstmt.setInt(2,6000);
            //5、执行 sql
            int count = pstmt.executeUpdate();
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.close(pstmt,conn);
        }

    }
}
