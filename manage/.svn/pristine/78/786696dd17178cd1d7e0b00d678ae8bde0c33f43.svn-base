package com.op.flow.manage.util;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JSP页面的request请求应用类
 */

public class RequestUtil {
    /**
     * 获取Request的整型参数
     */
    public static double getDoubleParameter(HttpServletRequest request, String name, double defaultValue) {
        double val = defaultValue;
        try {
            val = Double.parseDouble(request.getParameter(name));
        } catch (Exception e) {
            val = defaultValue;
        }
        return val;
    }

    /**
     * 获取Fload的整型参数
     */
    public static float getFloatParameter(HttpServletRequest request, String name, float defaultValue) {
        float val = defaultValue;
        try {
            val = Float.parseFloat(request.getParameter(name));
        } catch (Exception e) {
            val = defaultValue;
        }
        return val;
    }

    /**
     * 获取Request的整型参数
     */
    public static int getIntParameter(HttpServletRequest request, String name, int defaultValue) {
        int intValue = defaultValue;
        try {
            intValue = Integer.parseInt(request.getParameter(name));
        } catch (Exception e) {
            intValue = defaultValue;
        }
        return intValue;
    }

    /**
     * 获取Request的Long整型参数
     */
    public static long getLongParameter(HttpServletRequest request, String name, long defaultValue) {
        long longValue = defaultValue;
        try {
            Long tmpInteger = new Long(request.getParameter(name));
            longValue = tmpInteger.longValue();
        } catch (Exception e) {
            longValue = defaultValue;
        }
        return longValue;
    } // function

    /**
     * 获取Request的字符参数
     */
    public static String getStringParameter(HttpServletRequest request, String name, String defaultValue) {
        String strValue = request.getParameter(name);
        if (strValue == null) {
            strValue = "";
        }
        if (strValue.trim().equals(""))
            strValue = defaultValue;
        return strValue;
    }
    
    
    /**
     * 获取Request的Boolean参数
     */
    public static boolean getBooleanParameter(HttpServletRequest request, String name, boolean defaultValue) {
    	boolean boolValue = defaultValue;
    	try {
    		String data = request.getParameter(name);
    		if (!MSUtil.isEmpty(data)) {
    			boolValue = new Boolean(data);
    		}
        } catch (Exception e) {
        	boolValue = defaultValue;
        }
    	return boolValue;
    }

    /**
     * 处理Form输入(新闻内容)
     * 
     * @param str
     *            字符串
     * @return 处理后的字符串
     */
    public static String parseParameter(String str) {
        if (str == null)
            return "";
        else
            return str.trim();
    }

    public static Date getDateParameter(HttpServletRequest request, String key, Date defDate) {
        String s = request.getParameter(key);
        if (s != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                defDate = df.parse(s);
            } catch (Exception e) {
            }
        }
        return defDate;
    }

    public static Date getDateParameter(HttpServletRequest request, String key, Date defDate, String format) {
        String s = request.getParameter(key);
        if (s != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            try {
                defDate = df.parse(s);
            } catch (Exception e) {
            }
        }
        return defDate;
    }

    public static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteHost();
        }
        return ip;
    }

    /**
     * 获取域名第一组
     * @param request
     * @return
     */
    public static String findUserDomain(HttpServletRequest request) {
        String host = request.getHeader("host");
        if (StringUtil.isEmpty(host)) {
            return null;
        }
        String[] parts = host.split("\\.");
        if (parts.length < 3) {
            return null;
        }
        return parts[0];
    }

}