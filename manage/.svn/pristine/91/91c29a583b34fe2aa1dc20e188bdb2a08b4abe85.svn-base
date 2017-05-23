package com.op.flow.manage.odps;

import java.sql.*;
import java.util.Properties;

/**
 * Created by 孟凡伟 on 2017/5/5.
 */
public class OdpsUtil {
    /**
     * ODPS获取链接
     *
     * @return
     */
    public static Connection getConn() {
        Properties config = new Properties();
        Connection conn = null;
        try {
            Class.forName("com.aliyun.odps.jdbc.OdpsDriver");
            config.put("access_id", Resource.ODPS_ACCESSID);
            config.put("access_key", Resource.ODPS_ACCESSKEY);
            config.put("project_name", Resource.ODPS_PROJECT_NAME);
            conn = DriverManager.getConnection("jdbc:odps:"+Resource.ODPS_URL, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 资源释放
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void freeResources(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
