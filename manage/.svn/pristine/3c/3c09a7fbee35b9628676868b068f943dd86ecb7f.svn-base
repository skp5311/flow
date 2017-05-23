package com.op.flow.manage.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String transformCoding(String str, String coding1, String coding2) {
        String value = "";
        if (str == null || str.length() == 0) {
            return "";
        }

        try {
            value = new String(str.getBytes(coding1), coding2);
        } catch (Exception e) {
            return null;
        }
        return value;
    }

    /**
     * 判断字符串是否为空
     * @param source
     * @return
     */
    public static synchronized boolean isEmpty(String source) {
        if (source == null || source.trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符不能为空
     * @param source
     * @return
     */
    public static synchronized boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }

    /**
     * Integer列表去重
     * @param list
     * @return
     */
    public static List<Integer> distinctInt(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (result.contains(list.get(i))) {
                continue;
            }
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * 相交列表
     * @param list1
     * @param list2
     * @return
     */
    public static List<Integer> intersectInt(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list1.size();  i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).intValue() == list2.get(j).intValue()) {
                    result.add(list1.get(i));
                }
            }
        }
        return result;
    }

    /**
     * 移除字符串中括号内容
     * @param s
     * @return
     */
    public static String removeBracket(String s){
        if (StringUtil.isEmpty(s)) {
            return s;
        }
        return s.replaceAll("\\((.*)\\)", "");
    }

    public static String trimComma(String s){
        if (StringUtil.isEmpty(s)) {
            return s;
        }
        while(s.length() > 0) {
            if (s.charAt(0) != ',') {
                break;
            }
            s = s.substring(1);
        }
        while(s.length() > 0) {
            if (s.charAt(s.length()-1) != ',') {
                break;
            }
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /**
     * 获取第一组数值
     * @param str
     * @return
     */
    public static int findFirstInt(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        int value = 0;
        while (matcher.find()) {
            value = ParseUtil.parseInt(matcher.group(0));
            break;
        }
        return value;
    }

    public static void main(String[] args){
        System.out.println(trimComma("2,1,,"));
    }
}
