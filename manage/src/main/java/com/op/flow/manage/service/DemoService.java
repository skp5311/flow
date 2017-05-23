package com.op.flow.manage.service;

import com.op.flow.manage.dao.JdbcDemoDao;
import com.op.flow.manage.dao.JdbcGPDemoDao;
import com.op.flow.manage.dao.MyBatisDemoDao;
import com.op.flow.manage.dao.MyBatisGPDemoDao;
import com.op.flow.manage.odps.OdpsUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 孟凡伟 on 2017/5/4.
 */
@Repository
public class DemoService {
    private static final Logger logger = Logger.getLogger(DemoService.class);
    @Resource
    private MyBatisDemoDao myBatisDemoDao;

    @Resource
    private MyBatisGPDemoDao myBatisGPDemoDao;

    @Resource
    private JdbcDemoDao jdbcDemoDao;

    @Resource
    private JdbcGPDemoDao jdbcGPDemoDao;

    public int myBatisQueryCount() {
        return myBatisDemoDao.queryCount();
    }

    public int myBatisGPQueryCount() {
        return myBatisGPDemoDao.queryCount();
    }

    public int jdbcQueryData(){
        return jdbcDemoDao.queryData();
    }

    public int jdbcGPQueryData(){
        return jdbcGPDemoDao.queryData();
    }

    public int odpsQueryData(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = OdpsUtil.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(1) cnt from node");
            if (rs == null) {
                logger.error("rs is null");
                return 0;
            }
            while(rs.next()) {
                count = rs.getInt("cnt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            OdpsUtil.freeResources(rs, stmt, conn);
        }
        return count;
    }
}
