package com.op.flow.manage.dao.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import javax.annotation.Resource;
import java.util.List;

/**
 * MyBatis 数据基本操作
 * @author 孟凡伟
 * @version 2016-11-28 17:41:54
 */
public abstract class BaseGPDao<T extends Object> extends SqlSessionDaoSupport {

    @Resource
    public void setSqlSessionFactoryGP(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public int insert(String classMethod, T entity) throws DataAccessException {
        int flag = 0;
        try {
            flag = this.getSqlSession().insert(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return flag;
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public int update(String classMethod, T entity) throws DataAccessException {
        int flag = 0;
        try {
            flag = this.getSqlSession().update(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return flag;
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public Object queryCountForObject(String classMethod, Object entity) throws DataAccessException {
        Object result = null;
        try {
            result = (Object) this.getSqlSession().selectOne(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    public T queryForObject(String classMethod, T entity) throws DataAccessException {
        T result = null;
        try {
            result = (T) this.getSqlSession().selectOne(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public List<T> queryForList(String classMethod, T entity) throws DataAccessException {
        List<T> result = null;
        try {
            result = this.getSqlSession().selectList(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

    /**
     *
     * @param classMethod
     * @return
     * @throws DataAccessException
     */
    public List<T> queryForList(String classMethod) throws DataAccessException {
        List<T> result = null;
        try {
            result = this.getSqlSession().selectList(classMethod);
        } catch (DataAccessException e) {
            throw e;
        }
        return result;
    }

    /**
     *
     * @param classMethod
     * @param entity
     * @return
     * @throws DataAccessException
     */
    public int delete(String classMethod, T entity) throws DataAccessException {
        int flag = 0;
        try {
            flag = this.getSqlSession().delete(classMethod, entity);
        } catch (DataAccessException e) {
            throw e;
        }
        return flag;
    }

}
