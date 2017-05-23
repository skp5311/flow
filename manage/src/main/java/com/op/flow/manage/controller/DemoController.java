package com.op.flow.manage.controller;


import com.alibaba.fastjson.JSONObject;
import com.op.flow.manage.controller.base.BaseController;
import com.op.flow.manage.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 
 * @author 孟凡伟
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {

    @Resource
    private DemoService demoService;

    /**
     * 默认模版页面
     * @param model
     * @return
     */
    @RequestMapping(value = "index")
    public String index(Model model) {
        return "demo";
    }

    /**
     * 测试异步请求
     * @return
     */
    @RequestMapping(value = "json.do")
    @ResponseBody
    public JSONObject json() {
        JSONObject json = new JSONObject();
        json.put("myBatis-count", demoService.myBatisQueryCount());
        json.put("myBatis-gp-count", demoService.myBatisGPQueryCount());
        json.put("jdbc-count", demoService.jdbcQueryData());
        json.put("jdbc-gp-count", demoService.jdbcGPQueryData());
        json.put("odps-count", demoService.odpsQueryData());
        return json;
    }
}
