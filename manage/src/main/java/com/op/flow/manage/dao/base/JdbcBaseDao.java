package com.op.flow.manage.dao.base;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * Created by 孟凡伟 on 2017/5/4.
 */
public class JdbcBaseDao {
    @Resource
    public JdbcTemplate jdbcTemplate;

    @Resource
    public JdbcTemplate jdbcGPTemplate;
}
