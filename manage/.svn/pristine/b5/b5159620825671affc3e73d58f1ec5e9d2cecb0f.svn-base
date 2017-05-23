package com.op.flow.manage.dao;

import com.op.flow.manage.dao.base.JdbcBaseDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


/**
 * Created by 孟凡伟 on 2017/5/4.
 */
@Repository
public class JdbcDemoDao extends JdbcBaseDao{
    private static final Logger logger = Logger.getLogger(JdbcDemoDao.class);
    public int queryData(){
        long st = System.currentTimeMillis();
        int count = jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
        logger.info(System.currentTimeMillis() - st);
        return count;
    }
}
