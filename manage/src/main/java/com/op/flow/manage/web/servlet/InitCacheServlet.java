package com.op.flow.manage.web.servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 自动初始化缓存
 * Created by 孟凡伟 on 2016/9/28.
 */
public class InitCacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		NodeCache.getInstance();
//		RTCache.getInstance();
	}

}
