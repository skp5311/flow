package com.op.flow.manage.util.compares;


import com.op.flow.manage.util.ParseUtil;

import java.util.Comparator;

/**
 * Created by 孟凡伟 on 2016/10/21.
 */
public class StrComparator implements Comparator<String> {
    /**
     * 字符串比较，值为数字时，按数字比较
     * @param s1
     * @param s2
     * @return
     */
    public int compare(String s1, String s2) {
        int is1 = ParseUtil.parseInt(s1);
        int is2 = ParseUtil.parseInt(s2);
        if (s1.equals(String.valueOf(is1))
                && s2.equals(String.valueOf(is2))) {
            if (is1 > is2) {
                return 1;
            } else if (is1 < is2) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return s1.compareTo(s2);
        }
    }
}
