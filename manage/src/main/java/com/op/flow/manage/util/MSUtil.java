package com.op.flow.manage.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MSUtil {

    public static int parseInt(String str) {
        int returnValue = 0;
        try {
            returnValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            returnValue = 0;
        }
        return returnValue;
    }

    public static int parseInt(String str, int defaultValue) {
        int returnValue = defaultValue;
        try {
            returnValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            returnValue = defaultValue;
        }
        return returnValue;
    }

    public static float parseFloat(String str) {
        float returnValue = 0.0f;
        try {
            returnValue = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            returnValue = 0.0f;
        }
        return returnValue;
    }

    public static float parseFloat(String str, float defaultValue) {
        float returnValue = defaultValue;
        try {
            returnValue = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            returnValue = defaultValue;
        }
        return returnValue;
    }

    public static long parseLong(String str) {
        long returnValue = 0;
        try {
            returnValue = Long.parseLong(str);
        } catch (NumberFormatException e) {
            returnValue = 0;
        }
        return returnValue;
    }

    public static long parseLong(String str, long defaultValue) {
        long returnValue = defaultValue;
        try {
            returnValue = Long.parseLong(str);
        } catch (NumberFormatException e) {
            returnValue = defaultValue;
        }
        return returnValue;
    }

    public static double parseDouble(String str) {
        double returnValue = 0.0d;
        try {
            returnValue = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            returnValue = 0.0d;
        }
        return returnValue;
    }

    public static double parseDouble(String str, double defaultValue) {
        double returnValue = defaultValue;
        try {
            returnValue = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            returnValue = defaultValue;
        }
        return returnValue;
    }

    public static String enUTF8(String arg0) {
        String value = "";
        try {
            value = java.net.URLEncoder.encode(arg0, "UTF-8");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    public static String deUTF8(String arg0) {
        String value = "";
        try {
            value = java.net.URLDecoder.decode(arg0, "UTF-8");
        } catch (Exception e) {
            return "";
        }

        return value;
    }

    public static String encode(String arg0, String lg) {
        String value = "";
        try {
            value = java.net.URLEncoder.encode(arg0, lg);
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    public static String decode(String arg0, String lg) {
        String value = "";
        try {
            value = java.net.URLDecoder.decode(arg0, lg);
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从GBK 转换到 ISO8859_1
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String gbk2iso(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("GBK"), "ISO8859_1");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从 ISO8859_1 转换到 GBK
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String iso2gbk(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("ISO8859_1"), "GBK");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从 GBK 转换到 UTF-8
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String gbk2utf8(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("GBK"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从 UTF-8 转换到 GBK
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String utf82gbk(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("UTF-8"), "GBK");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从 ISO 转换到 UTF-8
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String iso2utf8(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 从 UTF-8 转换到 ISO
     * 
     * @param str
     *            需要转换字符集的字符串
     * @return 转换后的字符串
     */
    public static String utf82iso(String str) {
        String value = "";
        try {
            value = new String(str.getBytes("UTF-8"), "ISO-8859-1");
        } catch (Exception e) {
            return "";
        }
        return value;
    }

    /**
     * 中文转换Unicode码
     * @param str
     * @return String
     */
    public static String str2Unicode(String str) {
        if (MSUtil.isEmpty(str)) {
            return str;
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            if (chr1 >= 19968 && chr1 <= 171941) { // 汉字范围 \u4e00-\u9fa5 (中文)
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * Unicode码转换中文
     * @param ori
     * @return String
     */
    public static String unicode2Str(String ori) {
        if (MSUtil.isEmpty(ori)) {
            return ori;
        }
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = (value << 4) + aChar - '0';
                            break;
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                            value = (value << 4) + 10 + aChar - 'a';
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            value = (value << 4) + 10 + aChar - 'A';
                            break;
                        default:
                            throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }

    public static boolean isEmpty(String temp) {
        if (temp == null || temp.length() <= 0 || temp.equals("null") || temp.equals("{}") || temp.equals("[]")) {
            return true;
        }
        return false;
    }

    /**
     * 1.如果是空 判断是否为 null 中文，英文，HTML空格 为空 ? true : false;
     */
    public static boolean isEmpty2(String temp) {
        boolean bol = true;
        if (temp == null || temp.length() <= 0 || temp.equals("null")) {
            return bol;
        }
        try {
            temp = temp.replaceAll("[\u3000]+|[ ]+|&nbsp;", "");// \u3000
            // Unicode表示中文空格
        } catch (Exception e) {
        }
        return ("".equals(temp) || temp.length() <= 0) ? true : false;
    }

    /**
     * 判断一个List集合是否为空
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(List list) {
        boolean bol = true;
        if (list == null || list.size() == 0) {
            return bol;
        } else {
            return !bol;
        }
    }

    /**
     * 判断一个Map集合是否为空
     * @param map
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map) {
        boolean bol = true;
        if (map == null || map.size() == 0) {
            return bol;
        } else {
            return !bol;
        }
    }

    /**
     * 判断一个Object集合是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        boolean bol = true;
        if (obj == null) {
            return bol;
        } else {
            return !bol;
        }
    }

    /**
     * 补全 http://
     * 
     * @param url
     * @return
     */
    public static String setHttp(String url) {
        // String ww="ww.com";
        if (MSUtil.isEmpty(url)) {
            return "";
        }
        if (url.indexOf("http://") == -1) {
            return "http://" + url;
        }
        return url;
    }

    /** 电子邮件格式判断 如果不是返回 false 是 返回 true */
    public static boolean isEmail(String str) {
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        boolean bol = str.matches(regex);
        if (bol == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 短日期验证
     * 
     * @param str
     * @return
     */
    public static boolean isShotDate(String str) {
        String regex = "^(\\d{4})\\-([1-9]|[0-1][0-2])\\-([1-9]|[0-3][0-9])$";
        boolean bol = str.matches(regex);
        if (bol == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回替换掉各种空格（中文，英文，HTML空格）后的字符串
     */
    public static String replaceBlank(String temp) {
        if (temp == null || temp.equals("")) {
            return "";
        }
        try {
            temp = temp.replaceAll("[\u3000]+|[ ]+|&nbsp;", "");// \u3000
            // Unicode表示中文空格
        } catch (Exception e) {
        }
        return temp;
    }

    public static String replace(String temp, String reg, String toReg) {
        if (MSUtil.isEmpty(temp)) {
            return "";
        }
        try {
            temp = temp.replaceAll(reg, toReg);// \u3000 Unicode表示中文空格
        } catch (Exception e) {
        }
        return temp;
    }

    /** 
     * ex : ,,,,ss,,2,,,3,33,
     * 截了之后　2,3,33
     * 截去非数字符号 和拼一下新　逗号字符串
     * return 1,2,3
     */
    /*public static String clearInvalidCommaAndNoNumber(String s){
    
    	if(isEmpty(s)){
    		return "";
    	}
    	if(s.contains(",")==false){
    		return s;
    	}
    	String a[] = s.split(",");
    	String apd = "";
    	for(int i=0;i<a.length;i++){
    		if(isEmpty(a[i])){
    			continue ;
    		}
    		apd += a[i]+",";
    	}
    	
    	return cutLastlyComma(apd);
    }*/

    public static String clearInvalidComma(String s) {

        if (isEmpty(s)) {
            return "";
        }

        if (s.contains(",") == false) {
            return s;
        }

        s = s.replaceAll(",+,", ",");
        int mxLength = s.length();
        //System.out.println(" mxLength:"+mxLength+" s:"+s);

        if (s.equals(",")) {
            return "";
        }

        int begin = 0;
        int end = mxLength;
        if (mxLength > 1) {

            String frist = s.substring(0, 1);
            if (frist.equals(",")) {
                begin = 1;
            }

            String last = s.substring(mxLength - 1, mxLength);
            if (last.equals(",")) {
                end = mxLength - 1;
            }

            //System.out.println("[frist:"+frist+" last:"+last+"][begin:"+begin+" end:"+end+"]");
        }

        //if(end>0){
        s = s.substring(begin, end);
        //}

        //System.out.println("str:["+s+"]");
        return s;
    }

    /*
     * 特殊字符串整理器 ex : ,,,,ss,,2,,,3,33, 截了之后　2,3,33 截去非数字符号 和拼一下新　逗号字符串
     
    public static String stringAdjust(String s) {
    
    	if (s == null || isEmpty(s))
    		return "";
    
    	if(s.contains(",")==false){
    	//if (s.indexOf(",") == -1)
    		return s;
    	}
    	
    	String a[] = s.split(",");
    
    	StringBuffer apd = new StringBuffer();
    
    	for (int i = 0; i < a.length; i++) {
    		apd.append(!isEmpty(a[i]) ? (a[i] + ",") : "");
    	}
    
    	return cutLastlyComma(apd.toString());
    }
     */
    /*
     * 截去字符串最后一个逗号
     */
    public static String cutLastlyComma(String s) {

        String str = s;
        if (isEmpty(str))
            return "";

        // 截去字符串最后一个逗号
        //if (s.indexOf(",") == -1) {
        if (s.contains(",") == false) {
            return s;
        }

        int size = s.length();
        String comma = s.substring(size - 1, size);
        if (comma.equals(",")) {
            str = s.substring(0, size - 1);
        }

        return str;
        //return clearInvalidComma(s);
    }

    /*
     * 截去字符串最后一个逗号
     */
    public static String cutLastlyComma(String s, String reg) {
        String str = s;
        if (isEmpty(str))
            return "";

        // 截去字符串最后一个逗号
        if (s.contains(reg) == false) {
            return s;
        }

        //if (s.indexOf(reg) != -1) {

        //}

        int size = s.length();
        String comma = s.substring(size - reg.length(), size);
        if (comma.equals(reg)) {
            str = s.substring(0, size - reg.length());
        }

        return str;
    }

    /**
     * 截取一个字符串中begin和end之间的内容，如果end为空字符串或者null，则截取到字符串结尾
     * @param data 被截取的数据
     * @param begin 开始字符串
     * @param end	结束字符串
     * @return
     */
    public static String substring(String data, String begin, String end) {
        if (data == null || data.equals("")) {
            return data;
        }
        data = data.substring(data.indexOf(begin) + begin.length(), data.length());
        int endIndex = data.length();
        if (!MSUtil.isEmpty(end)) {
            endIndex = data.indexOf(end);
        }
        return data.substring(0, endIndex);
    }

    /*
     * 特殊字符串整理器 ex : ,,,,ss,,2,,,3,33, 截了之后　2,3,33 截去非数字符号 和拼一下新　逗号字符串
     */

    public static String stringAdjust(String s, String reg) {

        if (s == null || isEmpty(s))
            return "";

        if (s.indexOf(reg) == -1)
            return s;

        String a[] = s.split(reg);

        StringBuffer apd = new StringBuffer();

        for (int i = 0; i < a.length; i++) {
            apd.append(!isEmpty(a[i]) ? (a[i] + reg) : "");
        }

        return cutLastlyComma(apd.toString(), reg);
    }

    /**
     * 替换掉输入的用户非法字符串 \\\\ = \
     */
    public static String replaceSign(String str) {

        if (isEmpty(str))
            return "";

        String cls_blank = str;

        try {
            String regEx = "[+/^*%-]|[{}()<>]|[?.\"\'\\\\]|[:$!&;#$]|[\n\b\r]";// GBKtoISO("!");//传过来的字符串和正则编码一定要统一
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            cls_blank = m.replaceAll("");// 把非法字符串替换在空
        } catch (Exception e) {

        }
        return cls_blank;
    }

    // 过滤掉所有html标识，可以在在线编辑器提交验证时用。
    public static String clearHtml(String content) {
        String reg = "(<[^>]*>)|&nbsp;+";
        content = content.replaceAll(reg, "");
        return content;
    }

    public static String replaceHtmlBracket(String content) {
        //String str = "";
        content = content.replaceAll("\"", "&quot;");
        content = content.replaceAll("\'", "&prime;");
        content = content.replaceAll("\\\\", "&#92;");
        content = content.replaceAll("<", "&lt;");
        content = content.replaceAll(">", "&gt;");
        return content;
    }

    public static String toBracketHtml(String content) {
        content = content.replaceAll("&lt;", "<");
        content = content.replaceAll("&gt;", ">");
        return content;
    }

    public static String removehtmltag(String htmlstr) {

        if (htmlstr == null)
            return "";
        //htmlstr = htmlspecialchars_decode(htmlstr);
        htmlstr = htmlstr.replaceAll("<!--[\\s\\S]*?-->", "");
        // htmlstr = htmlstr.replaceAll("\n", "<BR>");
        Pattern pat = Pattern.compile("\\s*<.*?>\\s*", Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(htmlstr);
        String rs = m.replaceAll("       ");
        rs = rs.replaceAll("&nbsp;", "       ");
        rs = rs.replaceAll("<", "&lt;");
        rs = rs.replaceAll(">", "&gt;");
        rs = rs.replaceAll("   ", "");
        return rs;

    }

    public static String removehtmltag2(String htmlstr) throws UnsupportedEncodingException {

        if (htmlstr == null)
            return "";

        //htmlstr = htmlstr.replaceAll("<!--[\\s\\S]*?-->", "");
        // htmlstr = htmlstr.replaceAll("\n", "<BR>");
        /*Pattern pat = Pattern.compile("\\s*<.*?>\\s*", Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(htmlstr);
        String rs = m.replaceAll("       ");
        rs = rs.replaceAll("&nbsp;", "       ");
        rs = rs.replaceAll("<", "&lt;");
        rs = rs.replaceAll(">", "&gt;");
        rs = rs.replaceAll("   ", "");*/
        //htmlstr = htmlstr.replaceAll("<!--", "");
        //htmlstr = htmlstr.replaceAll("<!--.*?-->", "");
        // 去掉所有解本
        //htmlstr = htmlstr.replaceAll("<script.*?>.*?</script.*?>", "");
        //htmlstr = htmlstr.replaceAll("script", "EscriptE");
        htmlstr = htmlstr.replaceAll("escripte", "script");
        //	htmlstr = htmlstr.replaceAll("<script.*?>|&lt;script.*?&gt;", "[script type='text/javascript']");
        //htmlstr = htmlstr.replaceAll("</script.*?>|&lt;/script.*?&gt;", "[/script]");

        //htmlstr = htmlstr.replaceAll("<script.*?>", "[script type='text/javascript']");
        //htmlstr = htmlstr.replaceAll("</script.*?>", "[/script]");

        htmlstr = htmlstr.replaceAll("<script.*?>", "&lt;script type='text/javascript'&gt;");
        htmlstr = htmlstr.replaceAll("</script.*?>", "&lt;/script&gt;");

        return htmlstr;

    }

    public static String removehtmltag3(String htmlstr) {

        if (htmlstr == null)
            return "";
        //htmlstr = htmlspecialchars_decode(htmlstr);
        htmlstr = htmlstr.replaceAll("<!--[\\s\\S]*?-->", "");
        htmlstr = htmlstr.replaceAll("<br>", "\n");

        Pattern pat = Pattern.compile("\\s*<.*?>\\s*", Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(htmlstr);
        String rs = m.replaceAll("");
        rs = rs.replaceAll("\n", "<br>");
        //rs = rs.replaceAll("&nbsp;", "       ");
        //rs = rs.replaceAll("<", "&lt;");
        //rs = rs.replaceAll(">", "&gt;");
        //rs = rs.replaceAll("   ", "");
        return rs;

    }

    public static String[] filterRepeatContent(String str, String reg) {
        // String str =
        // "1,2,3,1,11,4,5,6,2,3,1,2,3,4,5,,6,7,8,1,2,2,9,10,100,3,11,333,";
        String[] arrayTemp = new String[0];
        try {
            if (MSUtil.isEmpty(str))
                return arrayTemp;

            str = MSUtil.clearInvalidComma(str);

            String[] array = str.split(reg);

            Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < array.length; i++) {
                if (map.get(array[i]) == null) {
                    map.put(array[i], array[i]);
                }
            }
            arrayTemp = (String[]) map.keySet().toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            arrayTemp = new String[0];
        }
        return arrayTemp;
        // String[] keyArray = (String[]) map.keySet().toArray(new String[0]);
        // for(int i=0;i<keyArray.length;i++){
        // System.out.println(keyArray[i]);
        // }
    }

    /**
     * 过滤一个字符串中重复内容
     * 
     * @param str
     * @return
     */
    public static String[] filterRepeatString(String str) {
        return filterRepeatContent(str, ",");
    }

    public static String filterRepeatStr(String str) {
        return filterRepeatStr(str, ",");
    }

    public static String filterRepeatStrByReg(String str, String reg) {
        return filterRepeatStr(str, reg);
    }

    public static String filterRepeatStr(String str, String reg) {
        String[] array = filterRepeatContent(str, reg);
        String temp = "";
        if (array == null || array.length <= 0)
            return temp;

        for (int i = 0; i < array.length; i++) {
            temp += array[i] + ",";
        }

        temp = MSUtil.clearInvalidComma(temp);

        return temp;
        // String[] keyArray = (String[]) map.keySet().toArray(new String[0]);
        // for(int i=0;i<keyArray.length;i++){
        // System.out.println(keyArray[i]);
        // }
    }

    /*public static String getMTSrc(MsAdMaterial entity, int flag) {
    	System.out.println("getMaterial entity.getType()" + entity.getType());
    
    	String defaultImg = "default.jpg";
    	String fileDomain = UNACache.material_url;
    	String dir = "";
    	if (entity.getType() == 1) {
    		dir = "img/";
    	} else if (entity.getType() == 2) {
    		dir = "swf/";
    	} else if (entity.getType() == 3) {
    		dir = "flv/";
    	}
    	if (entity == null || entity.getCustomId() <= 0) {
    		return fileDomain + defaultImg;
    	}
    
    	if (flag == 1) {// 返回原始文件路径
    		// if(MSUtil.isEmpty(entity.getFileName())){
    		// return fileDomain+defaultImg;
    		// }
    		return fileDomain + dir + entity.getFileName();// fileDomain+"materials/upload/"+entity.getAdcustomId()+"/"+filename;
    	} else {
    		// if(MSUtil.isEmpty(entity.getMinName())){
    		// return fileDomain+defaultImg;
    		// }
    		return fileDomain + dir + entity.getMinName();
    	}
    }*/

    public static boolean outs(JSONObject data, javax.servlet.http.HttpServletResponse response) {
        return outs(data.toString(), response);
    }

    public static boolean outs(String data, javax.servlet.http.HttpServletResponse response) {
        try {
            //			response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 字符串以空格分割
     * 
     * @param a
     * @return
     */
    public static String toBlankSpace(Object a) {
        String ad = String.valueOf(a);
        String str1 = new StringBuilder(ad).reverse().toString(); // 先将字符串颠倒顺序
        String str2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (i * 3 + 3 > str1.length()) {
                str2 += str1.substring(i * 3, str1.length());
                break;
            }
            str2 += str1.substring(i * 3, i * 3 + 3) + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        // 最后再将顺序反转过来
        String s = new StringBuilder(str2).reverse().toString();
        return s;
    }

    // 去除数组中重复数据
    public static String[] array_unique(String[] a) {
        // array_unique
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < a.length; i++) {
            if (!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    // 数组转换为逗号分割字符串
    public static String array_split(String[] a) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + ",");
        }
        String s = sb.toString();
        return s;
    }

    // 计算百分率
    public static String percentage(String a, String b) {
        float pre = 0.0f;
        try {

            float aa = MSUtil.parseFloat(a);
            float bb = MSUtil.parseFloat(b);
            //System.out.println(aa+"  "+bb);
            if (aa <= 0)
                return pre + "";
            if (bb <= 0)
                return pre + "";
            pre = (float) (aa / bb * 100);
            pre = Math.round(pre * 100) / 100;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pre + "%";
    }

    //计算小数
    public static String decimal(String a, String b) {
        double pre = 0.0d;
        double c = 0.0d;
        int b1 = 0;
        try {
            double aa = MSUtil.parseDouble(a);
            double bb = MSUtil.parseDouble(b);
            if (aa <= 0)
                return pre + "";
            if (bb <= 0)
                return pre + "";
            pre = (aa / bb);
            b1 = (int) Math.round(pre * 10); //小数点后移两位
            c = ((double) b1 / 10.0); //还原小数点后两位

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return c + "";
    }

    //比较大小返回0或1
    public static int comparison(String one, String two) {
        int a = parseInt(one);
        int b = parseInt(two);
        if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String getStringLength(String str) {
        int length = 0;
        if (str != "" && str != null) {
            length = str.length();
        }
        return length + "";
    }

    public static String getPercent(long first, long second) {
        NumberFormat numberFormat = NumberFormat.getInstance();// 创建一个数值格式化对象
        numberFormat.setMaximumFractionDigits(2);// 设置精确到小数点后2位
        String result = numberFormat.format((float) (first) / (float) (second) * 100);
        return result + "%";
    }

    public static String getcha(long first, long second, long three, long four) {
        NumberFormat numberFormat = NumberFormat.getInstance();// 创建一个数值格式化对象
        numberFormat.setMaximumFractionDigits(2);// 设置精确到小数点后2位
        float f = (float) (first) / (float) (second) * 100;
        float s = (float) (three) / (float) (four) * 100;
        String result = numberFormat.format(f - s);
        return result + "%";

    }

    //截取字符串,起始位置自定义
    public static String getSubString(String str, int i, int j) {
        String s = "";
        if (!str.isEmpty()) {
            s = str.substring(i, j);
        }
        return s;
    }

    //差值
    public static long getDiffer(long a, long b) {
        long s = 0;
        s = a - b;
        return s;

    }

    //获取IP
    public static String getUserIp(HttpServletRequest request) throws Exception {
        String ip = "";

        if (request.getHeader("x-forwarded-for") != null && (!request.getHeader("x-forwarded-for").trim().equals(""))) {
            ip = request.getHeader("x-forwarded-for").split(",")[0];
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 
     * @param str
     * @param length
     *            要输出的英文的长度 两个英文代表一个中文.
     * @return 截取后的字符串
     */
    public static String getFixWidthSub(String str, int length) {
        int j = 0;
        if (str == null || str.equals("")) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            if (((int) (str.charAt(i))) > 255) {
                j += 2;
            } else {
                j++;
            }
            if (j > length) {
                return str.substring(0, i) + "...";
            }
        }
        return str;
    }

    /*public static String getUserSrc(User entity , int flag) {
    	return getSrc(entity.getImgName() ,entity.getUserId(), flag);
    }*/

    // http://localhost:18480/a/upload/0/1-20130104232306970_3.jpg
    public static String getUserId(String imgSrc) {
        String tmp = imgSrc;
        if (imgSrc != null && imgSrc.indexOf("-") != -1) {
            int end = imgSrc.lastIndexOf("-");
            if (end > 0) {
                tmp = imgSrc.substring(0, end);
            }
        }
        return tmp;
    }

    /* public static void main(String[] args) {
    	String sss = getRelativePath("","601",3);
    	System.out.println(sss);
    }*/
    /**
     * 将ID按三位分割
     * @param path
     * @param eid
     * @param dirLen
     * @return
     */
    public static String getRelativePath(String path, String eid, int dirLen) {
        String dir = "";
        String filename = eid;

        dirLen = dirLen <= 0 ? 3 : dirLen;

        int len = (filename.length() < dirLen && filename.length() > 0) ? filename.length() : dirLen;

        while (len > 0) {
            String tmp = filename.substring(0, len);
            dir += tmp + "/";
            File dirFile = new File(path + dir);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            filename = filename.substring(len);
            len = (filename.length() < dirLen) ? filename.length() : dirLen;
        }
        return dir;
    }

    public static int indOf(String a, String b) {
        if (MSUtil.isEmpty(a) || MSUtil.isEmpty(b)) {
            return -1;
        }
        int ind = ("," + a + ",").indexOf("," + b + ",");
        return ind;
    }

    /*public static void main(String[] args) {
    	String sss = getRelativePath("","601",3);
    	System.out.println(sss);
    	int index=2;
    	
    	String fileName="20130328152640593_11.jpg";
    	fileName = fileName.replaceAll("[_]([\\d]+)[.]", "_"+index+".");
    	
    	System.out.println(fileName);
    }*/

    /**
     * 隐式提交表单
     * @param formName 表单名称
     * @param inputType 表单类型  默认为 hidden
     * @param inputName 表单input name
     * @param value input value
     * @param method 是以 get 还是post方式 传参 ,默认为post
     * @return
     */
    public static String sendRedirect(String page, String formName, String inputName, String inputType, String value, String method) {
        method = MSUtil.isEmpty(method) ? "post" : method;
        inputType = MSUtil.isEmpty(inputType) ? "hidden" : inputType;

        StringBuilder form = new StringBuilder();
        form.append("<form name='" + formName + "' method='" + method + "'>");
        form.append("<input type='" + inputType + "' name='" + inputName + "' value='" + value + "'/>");
        form.append("</form>");
        form.append("<script type='text/javascript'>");
        form.append("var fm = document.forms['" + formName + "'];");
        form.append("fm.method='" + method + "';");
        form.append("fm.action='" + page + "';");
        form.append("fm.submit();");
        form.append("</script>");
        return form.toString();
    }

    // 【1缓存流操作】将对象写入字符串
    public static String serialzeToStringByGBK(Object content) {

        return serialzeToString(content, "GBK");
    }

    public static String serialzeToStringByISO(Object content) {
        return serialzeToString(content, "ISO-8859-1");
    }

    public static String serialzeToStringByUTF8(Object content) {
        return serialzeToString(content, "UTF-8");
    }

    public static String serialzeToString(Object o, String code) {
        ObjectOutputStream os = null;
        try {
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bs);
            os.writeObject(o);
            byte[] bytes = bs.toByteArray();
            //String retStr = new String(bytes,"ISO-8859-1");
            String retStr = new String(bytes, code);
            return retStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //【2缓存流操作】从字符串中读取出对象
    public static Object derialzeFromStringByGBK(String content) {
        return derialzeFromString(content, "GBK");
    }

    public static Object derialzeFromStringByISO(String content) {
        return derialzeFromString(content, "ISO-8859-1");
    }

    public static Object derialzeFromStringByUTF8(String content) {
        return derialzeFromString(content, "UTF-8");
    }

    public static Object derialzeFromString(String content, String code) {
        ObjectInputStream ois = null;
        try {
            byte[] bytes = content.getBytes(code);
            // byte[] bytes = content.getBytes("ISO-8859-1");
            ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bs);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取指定长度的内容，超出指定长度内容将被丢弃
     * @param str
     * @param maxLen 中文长度，不是英文长度乘以2，一个中文长度为1，一个英文长度为0.5
     * @return
     */
    public static String getZHLengthStr(String str, int maxLen) {
        StringBuilder sb = new StringBuilder();
        float strlength = 0;
        for (int i = 0; i < str.length(); i++) {

            int indCode = (int) (str.charAt(i));
            if (indCode > 255)
                strlength = strlength + 1;
            else
                strlength = strlength + 0.5f;

            int le = (int) Math.floor(strlength);
            if (strlength <= maxLen) {
                sb.append(str.charAt(i));
            } else {
                break;
            }

            System.out.println("index str:" + str.charAt(i) + "==" + strlength + "==" + le);
        }
        return sb.toString();

    }

    /**
     * * 逗号分割的字符串比较，找出共同存在的内容
     * @param str1 第一个参数最好传短的那个串，相对来说效率要高一些
     * @param map2 被比较串
     * @return
     */
    public static Map<String, String> getEquals(String str1, Map<String, String> map2) {
        //System.out.println("==================================================getEquals "+str1);
        if (MSUtil.isEmpty(str1)) {
            System.out.println("getEquals is null" + str1);
            return map2;
        }

        String[] ids = str1.split(",");
        return getEquals(ids, map2);//取真交集
        //return getEquals2(ids,map2);
    }

    /**
     * 此方法发现map2为空或者size为0时,直接返回空
     * 取交集【当ids不空null，mp2为空时说明没有交集，说明当前二组查找失败】
     * @param ids
     * @param map2
     * @return
     */
    public static Map<String, String> getEquals(String[] ids, Map<String, String> map2) {
        //System.out.println("==================================================getEquals2 "+ids.length+"---map2:"+map2);
        StringBuilder temp = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        if (ids == null || ids.length <= 0) {
            temp.append("ids is null");
            //System.out.println("==================================================getEquals3 "+temp.toString());
            return map2;
        }

        if (map2 == null || map2.size() <= 0) {
            return map;
        }

        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            // 如果map2中存在ids中的内容，那么提出来
            if (map2.get(id) != null) {
                map.put(id, "");
            }
        }
        //System.out.println("==================================================getEquals4 "+temp.toString());
        return map;
    }

    /**
     * 此方法发现map2为空或者size为0时会把 ids转成map后返回
     * @param ids
     * @param map2
     * @return
     */
    public static Map<String, String> getEquals2(String[] ids, Map<String, String> map2) {
        //System.out.println("==================================================getEquals2 "+ids.length+"---map2:"+map2);
        StringBuilder temp = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        if (ids == null || ids.length <= 0) {
            temp.append("ids is null");
            //System.out.println("==================================================getEquals3 "+temp.toString());
            return map2;
        }

        if (ids != null && (map2 == null || map2.size() <= 0)) {
            // 如果map2没有内容那么将ids转换成map2
            for (int i = 0; i < ids.length; i++) {
                String id = ids[i];
                temp.append("id:" + id);

                // 如果map2中存在ids中的内容，那么提出来
                if (!MSUtil.isEmpty(id)) {
                    map.put(id, "");
                }
            }
            return map;
        }

        for (int i = 0; i < ids.length; i++) {
            String id = ids[i];
            // 如果map2中存在ids中的内容，那么提出来
            if (map2.get(id) != null) {
                map.put(id, "");
            }
        }
        //System.out.println("==================================================getEquals4 "+temp.toString());
        return map;
    }

    /*单价（单选）：price1
    颜色（单选）：color1
    分类（多选）：typeId1,typeId2,typeId3,typeId4
    
    
    单价+分类
    颜色+分类 
    单价+颜色+分类*/
    public static String[] getKeyAraay(String price, String color, String typeIds) {
        if (MSUtil.isEmpty(typeIds)) {
            return null;
        }

        String keys = getKEYS(price, color, typeIds);
        if (MSUtil.isEmpty(keys)) {
            return null;
        }

        String[] keyArray = keys.split(",");

        return keyArray;
    }

    /*
     单价（单选）：price1
    颜色（单选）：color1
    分类（多选）：typeId1,typeId2,typeId3,typeId4
    单价+分类
    颜色+分类 
    单价+颜色+分类*/
    public static String getKEYS(String price, String color, String typeIds) {
        // 此方法必须保证 【单价，颜色，分类】ID必须是唯一不重复的。
        //String spId = 1;
        //String zjId = 1;

        //String[] keyArray=null;
        //long price=1;
        //long color=3;
        //String typeIds="1,2,3,4,5,6,7,8,9,10,11,12";
        String[] typeIdArray = typeIds.split(",");

        String keys = "";
        for (int i = 0; i < typeIdArray.length; i++) {
            //long typeId = MSUtil.parseLong( typeIdArray[i] );
            String typeId = typeIdArray[i];
            if (MSUtil.isEmpty(typeId)) {
                continue;
            }

            //单价+分类
            //颜色+分类 
            //单价+颜色+分类
            String price_typeId = "";
            if (!MSUtil.isEmpty(price) && !price.equals(typeId)) {
                //if(price!=typeId){
                price_typeId = price + "_" + typeId;
            }

            String color_typeId = "";
            if (!MSUtil.isEmpty(color) && !color.equals(typeId)) {
                //if(color!=typeId){
                color_typeId = color + "_" + typeId;
            }

            String tempTypeId = "";
            if (!price.equals(typeId) && !color.equals(typeId)) {
                //if(price!=typeId && color!=typeId){
                // 不会单独根据单价 或者 颜色 单独查询。 
                tempTypeId = typeId + "";
            }

            String price_color_typeId = "";
            if (!MSUtil.isEmpty(price) && !MSUtil.isEmpty(color)) {
                price_color_typeId = price + "_" + color + "_" + typeId;
            }

            keys += tempTypeId + "," + price_typeId + "," + color_typeId + "," + price_color_typeId + ",";

        }
        keys = MSUtil.clearInvalidComma(keys);

        System.out.println(keys.split(",").length + "\nkeys-->" + keys);

        //keyArray = keys.split(",");
        //return keyArray ;
        return keys;

    }

    /**
     * 写文件操作
     * 
     * @param fileName 日志文件的全路径 path + init-2012-08-16-00-118.242.45.85-8280.txt
     * @param content 写入内容
     */
    public static synchronized void write(String fileName, String content) {

        try {
            boolean append = true;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
            writer.write(content);
            /*if (isAutoNewLine) {
            	writer.newLine();
            }*/
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 提交到Iframe回调交窗口页面
    public static String call_back_script(String methodName) {
        String script_str = "";
        script_str += "<script type=text/javascript>";
        //script_str += "parent.window.del_photo_info('"+info+"');";
        script_str += "parent.window." + methodName + ";";
        //script_str += "top.window."+methodName+";";
        script_str += "</script>";
        return script_str;
    }

    /**
     * 格式化mac地址，小写去掉:或者-，变为12位字符串
     * @param mac
     * @return String
     */
    public static String formatMac(String mac) {
        if (mac == null || mac.equals("")) {
            return null;
        }
        String split1 = ":";
        String split2 = "-";
        if (mac.indexOf(split1) != -1) {
            mac = mac.replace(split1, "");
        } else if (mac.indexOf(split2) != -1) {
            mac = mac.replace(split2, "");
        }
        return mac.toLowerCase();
    }

    /**
     * 根据ua判断是否是PC
     * @param ua
     * @return boolean
     */
    public static boolean isPC(String ua) {
        boolean isPC = true;
        if (isEmpty(ua))
            return isPC;
        ua = ua.toLowerCase();
        if (ua.indexOf("windows nt") > 0 || ua.indexOf("macintosh") > 0 || ua.indexOf("x11") > 0)
            isPC = true;
        else
            isPC = false;

        return isPC;
    }

    /**
     * 打印错误日志信息
     */
    public static void print(Exception e) {
        if (e.getMessage() != null) {
            System.out.println("@Time: " + DateUtil.getCurrentTime() + " @MSG：" + e.getMessage());
        }
    }

    /**
     * 打印一句话，在打印前添加打印具体时间
     */
    public static void print(String msg) {
        System.out.println("@Time: " + DateUtil.getCurrentTime() + " @MSG：" + msg);
    }

    /**
     * 打印一个对象，在打印前添加打印具体时间
     */
    public static void print(Object obj) {
        System.out.println("@Time: " + DateUtil.getCurrentTime() + " @MSG：" + obj);
    }

    public static String genRandomNum(int pwd_len) {
        //35是因为数组是从0开始的，26个字母+10个数字  
        final int maxNum = 36;
        int i; //生成的随机数  
        int count = 0; //生成的密码的长度  
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            //生成随机数，取绝对值，防止生成负数，  

            i = Math.abs(r.nextInt(maxNum)); //生成的数最大为36-1  

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

}
