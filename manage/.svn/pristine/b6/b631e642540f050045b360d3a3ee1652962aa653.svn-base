package com.op.flow.manage.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 对象转换
 * Created by 孟凡伟 on 2016/10/21.
 */
public class ParseUtil {

    public static int parseInt(Long val) {
        return parseInt(val, 0);
    }
    public static int parseInt(Long val, int def) {
        if (val == null) {
            return def;
        }
        return val.intValue();
    }

    public static int parseInt(Integer val) {
        return parseInt(val, 0);
    }
    public static int parseInt(Integer val, int def) {
        if (val == null) {
            return def;
        }
        return val.intValue();
    }



    public static int parseInt(String s) {
        return parseInt(s, 0);
    }
    public static int parseInt(String s, int defaultValue) {
        try{
            return Integer.parseInt(s.trim());
        } catch (Exception ex){
        }
        return defaultValue;
    }

    public static Integer parseInteter(String s) {
        return parseInteter(s, null);
    }
    public static Integer parseInteter(String s, Integer defaultValue) {
        try{
            return Integer.parseInt(s.trim());
        } catch (Exception ex){
        }
        return defaultValue;
    }



    public static long parseLong(Long val) {
        if (val == null) {
            return 0;
        }
        return val.longValue();
    }

    public static long parseLong(Integer val) {
        if (val == null) {
            return 0;
        }
        return val.longValue();
    }

    public static long parseLong(String s) {
        return parseLong(s, 0);
    }
    public static long parseLong(String s, long defaultValue) {
        try{
            return Long.parseLong(s.trim());
        } catch (Exception ex){
        }
        return defaultValue;
    }

    public static Long parseLongObject(String s) {
        return parseLongObject(s, null);
    }
    public static Long parseLongObject(String s, Long defaultValue) {
        try{
            return Long.parseLong(s.trim());
        } catch (Exception ex){
        }
        return defaultValue;
    }

    /**
     * String转double
     * @param s
     * @return
     */
    public static double parseDouble(String s) {
        return parseDouble(s, 0d);
    }
    public static double parseDouble(String s, double defaultValue) {
        try{
            return Double.parseDouble(s);
        } catch (Exception ex){
        }
        return defaultValue;
    }

    /**
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static JSONObject parseJSONObject(Object obj, JSONObject defaultValue) {
        try{
            return JSONObject.parseObject(obj.toString());
        } catch (Exception ex){
        }
        return defaultValue;
    }

    /**
     *
     * @param obj
     * @param defaultValue
     * @return
     */
    public static JSONArray parseJSONArray(Object obj, JSONArray defaultValue) {
        try{
            if (obj == null){
                return defaultValue;
            }
            return JSONArray.parseArray(obj.toString());
        } catch (Exception ex){
        }
        return defaultValue;
    }
}
