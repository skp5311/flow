package com.op.flow.manage.controller.base;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基础控制类
 * Created by 孟凡伟 on 2016/9/20.
 */

public class BaseController {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * init binder, set datetime format
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateTimeFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(true);
        dateTimeFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateTimeFormat, true));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @InitBinder("page")
    public void initBinderPage(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("page.");
    }
}
