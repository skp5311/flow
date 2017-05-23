package com.op.flow.manage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    private static final TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");

    /**
     * @param date
     *            日期
     * @param day
     *            推移的天数
     * @param format1
     *            传入日期格式
     * @param format2
     *            返回日期格式
     * @return date 时间加天数的日期
     */
    public static String addDate(String date, int day, String format1, String format2) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate(date, format1));
        calendar.add(GregorianCalendar.DAY_OF_MONTH, day);
        SimpleDateFormat format = new SimpleDateFormat(format2);
        return format.format(calendar.getTime());
    }


    /**
     * @param day
     *            推移的天数
     * @param format
     *            返回日期格式
     * @return date 时间加天数的日期
     */
    public static String addDate(int day, String format) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(GregorianCalendar.DAY_OF_MONTH, day);
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(calendar.getTime());
    }

    /**
     * @param date
     *            日期
     * @param month
     *            推移的月数
     * @param format1
     *            传入日期格式
     * @param format2
     *            返回日期格式
     * @return date 时间加天数的日期
     */
    public static String addMonth(String date, int month, String format1, String format2) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate(date, format1));
        calendar.add(GregorianCalendar.MONTH, month);
        SimpleDateFormat format = new SimpleDateFormat(format2);
        return format.format(calendar.getTime());
    }

    /**
     * @param date
     *            日期
     * @param year
     *            推移的年数
     * @param format1
     *            传入日期格式
     * @param format2
     *            返回日期格式
     * @return date 时间加天数的日期
     */
    public static String addYear(String date, int year, String format1, String format2) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate(date, format1));
        calendar.add(GregorianCalendar.DAY_OF_MONTH, year);
        SimpleDateFormat format = new SimpleDateFormat(format2);
        return format.format(calendar.getTime());
    }

    /**
     * @param date
     *            日期
     * @param format
     *            返回格式
     * @return 日期字符串
     */
    public static String formatDate(Date date, String format) {
        String result = "";
        try {
            SimpleDateFormat formatter1 = new SimpleDateFormat(format);
            result = formatter1.format(date);
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * @param msel
     *            毫秒
     * @param format
     *            返回格式
     * @return 日期字符串
     */
    public static String formatDate(long msel, String format) {
        Date date = new Date(msel);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }

    /**
     * @param date
     *            日期
     * @param format2
     *            传入格式
     * @param format2
     *            返回格式
     * @return 日期字符串
     */
    public static String formatDate(String date, String format1, String format2) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate(date, format1));
        SimpleDateFormat format = new SimpleDateFormat(format2);
        return format.format(calendar.getTime());
    }

    /**
     * 获取当前系统时间，格式默认为yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前系统时间，格式默认为yyyy-MM-dd HH:mm:ss
     */
    public static int getCurrentDate() {
        int date = ParseUtil.parseInt(getThisday("yyyyMMdd"));
        return date;
    }

    /**
     * 获取当前系统时间（毫秒级），格式为yyyy-MM-dd HH:mm:ss.S
     */
    public static String getCurrentTimeMillis() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.S");
    }

    /**
     * 得到系统当前的日期
     * 
     * @return
     */
    public static int getCurrentDay() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到系统当前的月份
     * 
     * @return
     */
    public static int getCurrentMonth() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到系统当前的年
     * 
     * @return
     */
    public static int getCurrentYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 将一个字符串的日期描述转换为java.util.Date对象
     * 
     * @param strDate
     *            字符串的日期描述
     * @param format
     *            字符串的日期格式，比如:“yyyy-MM-dd HH:mm”
     * @return 字符串转换的日期对象java.util.Date
     */
    public static Date getDate(String strDate, String format) {
        if (strDate == null || strDate.trim().equals("")) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(timeZone);
        Date date;
        try {
            date = formatter.parse(strDate);
        } catch (Exception e) {

            date = null;
        }
        return date;
    }

    /**
     * 取两日期之间的天数间隔
     * 
     * @param strDate1
     *            日期1
     * @param strDate1
     *            格式1
     * @param strDate2
     *            日期2
     * @param strDate2
     *            格式2
     * @return
     */
    public static int getDistance(String strDate1, String format1, String strDate2, String format2) {
        int distance = 0;
        Date date1 = getDate(strDate1, format1);
        Date date2 = getDate(strDate2, format2);
        distance = (int) ((date2.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24);
        return distance;
    }

    /**
     * 得到系统的当前时间
     * 
     * @return
     */
    public static String getThisday(String format) {
        SimpleDateFormat d = new SimpleDateFormat(format);
        String dd = d.format(new Date());
        return dd;
    }

    /**
     * 返回昨天的时间
     * 
     * @return
     */
    public static String getYesterdaySS(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date tempDate = new Date();
        long tempLong = tempDate.getTime();
        tempLong = tempLong - (24 * 60 * 60 * 1000);
        tempDate.setTime(tempLong);
        String strDate = formatter.format(tempDate);
        return strDate;
    }

    /**
     * 计算一个月有多少天
     * 
     * @param year
     * @return int
     */
    public static int isMontyToDay(int year, int month) {
        int maxDate;
        month = month - 1;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        maxDate = cal.getActualMaximum(Calendar.DATE);
        return maxDate;
    }

    public static String[] getLastWeek(String date, String format1, String format2) {
        String[] result = new String[2];
        SimpleDateFormat sdf = new SimpleDateFormat(format2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate(date, format1));
        cal.set(Calendar.DAY_OF_WEEK, 1);
        result[1] = sdf.format(cal.getTime());
        cal.add(Calendar.WEEK_OF_MONTH, -1);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        result[0] = sdf.format(cal.getTime());
        return result;
    }

    public static String[] getLastMonth(String date, String format1, String format2) {
        String[] result = new String[2];
        SimpleDateFormat sdf = new SimpleDateFormat(format2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate(date, format1));
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        result[0] = sdf.format(cal.getTime());
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        result[1] = addDate(sdf.format(cal.getTime()), -1, format2, format2);
        return result;
    }

    public static String[] getLastQuarter(String date, String format1, String format2) {
        String[] result = new String[2];
        String temp = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format2);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(getDate(date, format1));
        int month = cal.get(Calendar.MONTH) + 1;
        if (month == 1 || month == 2 || month == 3) {
            temp = cal.get(Calendar.YEAR) + "-01-01";
        }
        if (month == 4 || month == 5 || month == 6) {
            temp = cal.get(Calendar.YEAR) + "-04-01";
        }
        if (month == 7 || month == 8 || month == 9) {
            temp = cal.get(Calendar.YEAR) + "-07-01";
        }
        if (month == 10 || month == 11 || month == 12) {
            temp = cal.get(Calendar.YEAR) + "-10-01";
        }
        result[1] = addDate(temp, -1, format2, format2);
        cal.setTime(getDate(temp, "yyyy-MM-dd"));
        cal.add(Calendar.MONTH, -3);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        result[0] = sdf.format(cal.getTime());
        return result;
    }

    public static ArrayList<String> getDateList(String beginDate, String endDate, String format1, String format2) {
        ArrayList<String> result = new ArrayList<String>();
        int intCurrent = Integer.parseInt(formatDate(beginDate, format1, "yyyyMMdd"));
        int intEnd = Integer.parseInt(formatDate(endDate, format1, "yyyyMMdd"));
        while (intCurrent <= intEnd) {
            result.add(formatDate("" + intCurrent, "yyyyMMdd", format2));
            intCurrent = Integer.parseInt(addDate("" + intCurrent, 1, "yyyyMMdd", "yyyyMMdd"));
        }
        return result;
    }

    /**
     * @param startDate
     *            起始日期字符串
     * @param endDate
     *            结束日期字符串
     * @param format
     *            转化格式
     * @return 比较结束日期比起始日期 0：相等 -1 ：结束早于起始，1：起始早于结束
     */
    public static int compareDates(String startDate, String endDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        int result = 0;
        try {
            long tempStart = sdf.parse(startDate).getTime();
            long tempEnd = sdf.parse(endDate).getTime();
            if (tempEnd - tempStart > 0) {
                result = 1;
            } else if (tempEnd - tempStart == 0) {
                result = 0;
            } else {
                result = -1;
            }
            /*
             * Date tempStart=sdf.parse(startDate); Date
             * tempEnd=sdf.parse(endDate); if(tempEnd.after(tempStart)) return
             * 1; else return-1;
             */
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static int getWeekOfDate(String strDate, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate(strDate, format));
        int result = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return result;
    }

    public static boolean isValidDate(String strDate, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(strDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取指定日期月份第一天
     * @param date
     * @return
     */
    public static Integer findFirstDayOfMonth(int date) {
        if (date <= 0) {
            return null;
        }
        return Integer.valueOf((int)Math.ceil(date / 100) * 100 + 1);
    }

    /**
     * 获取指定日期月份最后一天
     * @param date
     * @return
     */
    public static Integer findLastDayOfMonth(int date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate(date + "", "yyyyMMdd"));
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, -1);
        String s = df.format(cal.getTime());
        return Integer.valueOf(s);
    }



    public static void main(String[] args) {
//        Date date = new Date(1460035093L * 1000);
//        System.out.println(formatDate(date, "yyyyMMdd HH:mm:ss"));
//        date = new Date(System.currentTimeMillis());
//        System.out.println(formatDate(date, "yyyyMMdd HH:mm:ss"));
        System.out.println(findFirstDayOfMonth(20161109));
        System.out.println(findLastDayOfMonth(20161109));
    }

}