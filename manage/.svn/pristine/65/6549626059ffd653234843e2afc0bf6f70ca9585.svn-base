package com.op.flow.manage.dao;

import com.op.flow.manage.dao.base.JdbcBaseDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


/**
 * Created by 孟凡伟 on 2017/5/4.
 */
@Repository
public class JdbcGPDemoDao extends JdbcBaseDao{
    private static final Logger logger = Logger.getLogger(JdbcGPDemoDao.class);
    public int queryData(){
        long st = System.currentTimeMillis();
        int count = jdbcGPTemplate.queryForObject("select count(1) from data_swap.poi where day = 20170101", Integer.class);
        logger.info(System.currentTimeMillis() - st);
        return count;
    }
}
