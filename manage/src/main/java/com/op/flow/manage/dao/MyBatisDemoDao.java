package com.op.flow.manage.dao;

import com.op.flow.manage.dao.base.BaseDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * Created by 孟凡伟 on 2017/5/4.
 */
@Repository
public class MyBatisDemoDao extends BaseDao {
    private static final Logger logger = Logger.getLogger(MyBatisDemoDao.class);

    /** namespace */
    private final String namespace = MyBatisDemoDao.class.getName();

    public int queryCount(){
        long st = System.currentTimeMillis();
        int count = (int)this.queryCountForObject(namespace + ".queryCount", null);
        logger.info(System.currentTimeMillis() - st);
        return count;
    }
}
