package com.op.flow.manage.util;

public class FormatUtil {

    public static String formatMobile(String mobile) {
        String result = "";
        if (mobile == null)
            mobile = "";
        if (mobile.length() == 11) {
            result = mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
        }
        return result;
    }

    public static String formatMac(String mac) {
        String result = "";
        if (mac == null)
            mac = "";
        if (mac.length() == 17) {
            result = mac.substring(0, 2) + ":**:**:**:**:" + mac.substring(15, 17);
        }
        return result;
    }
    
    public static String formatDiff(int second){  
        int h = 0;  
        int d = 0;  
        int s = 0;  
        int temp = second%3600;  
             if(second>3600){  
               h= second/3600;  
                    if(temp!=0){  
               if(temp>60){  
               d = temp/60;  
            if(temp%60!=0){  
               s = temp%60;  
            }  
            }else{  
               s = temp;  
            }  
           }  
          }else{  
              d = second/60;  
           if(second%60!=0){  
              s = second%60;  
           }  
          }  

         return h+":"+d+":"+s;  
       }  

    public static void main(String[] args) {
    	System.out.println(formatDiff(3700));
    }
}
