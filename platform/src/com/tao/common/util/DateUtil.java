package com.tao.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {  
    
    /** 
     * 返回日期：yyyyMMddHHmmss格式的字符串 
     */  
    public static String getStrOfDate() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 获取当前日期时间 返回日期：yyyy-MM-dd HH:mm:ss 
     *  
     * @author WikerYong 
     * @version 2012-1-9 上午09:47:39 
     * @return 
     */  
    public static String getStrOfDateTime() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 字符串转为日期类型，返回yyyy-MM-dd HH:mm:ss格式 
     *  
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a> 
     * @version 2012-7-5 下午04:33:49 
     * @param str 
     * @return 
     */  
    public static Date getDateByStr(String str) {  
        Date date = new Date();  
        try {  
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            date = formatter.parse(str);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return date;  
    }  
      
    /** 
     * 获取当前日期时间 返回日期：yyyy-MM-dd HH:mm 
     *  
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a> 
     * @version 2012-1-31 下午02:57:30 
     * @return 
     */  
    public static String getStrOfDateMinute() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回日期：yyyyMMddHHmmssSSS格式的字符串 
     *  
     * @author WikerYong 
     * @version 2011-11-25 下午07:18:44 
     * @return 
     */  
    public static String getStrOfMs() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回日期：yyyyMM格式的字符串 
     */  
    public static String getMonthFolder() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回日期：yyyyMM格式的字符串 
     */  
    public static String getDateFolder() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 获取当前月份 
     *  
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a> 
     * @version 2012-4-9 上午10:45:28 
     * @return 
     */  
    public static String getMonth() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("MM");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 获取当前年份 
     *  
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a> 
     * @version 2012-7-5 下午04:31:07 
     * @return 
     */  
    public static String getYear() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回日期：yyyyMMddHH格式的字符串 
     *  
     * @author WikerYong 
     * @version 2011-12-20 下午03:43:14 
     * @return 
     */  
    public static String getDataOfHour() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回时间：yyyyMMddHHmm格式 
     */  
    public static String getStrOfTime() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    /** 
     * 返回时间：yyyy-MM-dd格式 
     */  
    public static String getCurrentDay() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  
      
    public static String getLastDay(int day) {  
        java.util.Date yestoday = new java.util.Date(new java.util.Date().getTime() - 1000 * 60  
                * 60 * 24 * day);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return sdf.format(yestoday);  
    }  
      
    /** 
     * 获取昨天、前天的日期 
     *  
     * @param currentDate 
     * @return 
     */  
    public static String[] getLastDates(String currentDate) {  
        String currYear, currMonth, currDay;  
        currYear = currentDate.substring(0, 4);  
        currMonth = currentDate.substring(4, 6);  
        currDay = currentDate.substring(6);  
          
        // 月份或日期首位是0  
        String tempMonth, tempDay;  
        if (currMonth.substring(0, 1).equals("0")) {  
            tempMonth = "0";  
        } else {  
            tempMonth = "";  
        }  
        if (currDay.substring(0, 1).equals("0") || currDay.equals("10")) {  
            tempDay = "0";  
        } else {  
            tempDay = "";  
        }  
          
        String returnDays[] = new String[2];  
          
        if (currMonth.equals("01") && currDay.equals("01")) {  
            returnDays[0] = (Integer.parseInt(currYear) - 1) + "1231";  
            returnDays[1] = (Integer.parseInt(currYear) - 1) + "1230";  
        } else if (currMonth.equals("01") && currDay.equals("02")) {  
            returnDays[0] = currYear + "0101";  
            returnDays[1] = (Integer.parseInt(currYear) - 1) + "1231";  
        } else if (Integer.parseInt(currMonth) >= 1 && Integer.parseInt(currDay) > 2) {  
            returnDays[0] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 1);  
            if (currDay.equals("11")) {  
                returnDays[1] = currYear + currMonth + "0" + (Integer.parseInt(currDay) - 2);  
            } else {  
                returnDays[1] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 2);  
            }  
        } else if (Integer.parseInt(currMonth) > 1 && Integer.parseInt(currDay) == 2) {  
            returnDays[0] = currYear + currMonth + "01";  
            if (currMonth.equals("10")) {  
                returnDays[1] = currYear  
                        + "0"  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));  
            } else {  
                returnDays[1] = currYear  
                        + tempMonth  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));  
            }  
        } else if (Integer.parseInt(currMonth) > 1 && Integer.parseInt(currDay) == 1) {  
            if (currMonth.equals("10")) {  
                returnDays[0] = currYear  
                        + "0"  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));  
                returnDays[1] = currYear  
                        + "0"  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)) - 1);  
            } else {  
                returnDays[0] = currYear  
                        + tempMonth  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));  
                returnDays[1] = currYear  
                        + tempMonth  
                        + (Integer.parseInt(currMonth) - 1)  
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),  
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)) - 1);  
            }  
        } else {  
            returnDays[0] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 1);  
            returnDays[1] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 2);  
        }  
          
        return returnDays;  
    }  
      
    public static int getLastDayOfUpMonth(int year, int month, int date) {  
        Calendar calendar = new GregorianCalendar(year, month, date);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天  
        calendar.add(Calendar.MONTH, -1);// 月增减1天  
        calendar.add(Calendar.DAY_OF_MONTH, -1);// 日期倒数一日,既得到本月最后一天  
        return calendar.get(Calendar.DATE);  
    }  
      
    /** 
     * 获取当月第一天 
     *  
     * @author WikerYong 
     * @version 2011-11-21 下午04:45:06 
     * @return 
     */  
    public static String getFirstDayOfMonth() {  
        String str = "";  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar lastDate = Calendar.getInstance();  
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号  
        str = sdf.format(lastDate.getTime());  
        return str;  
    }  
      
    /** 
     * 获取当月最后一天 
     *  
     * @author WikerYong 
     * @version 2011-11-21 下午04:46:06 
     * @return 
     */  
    public static String getLastDayOfMonteh() {  
        String str = "";  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
          
        Calendar lastDate = Calendar.getInstance();  
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号  
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号  
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天  
        str = sdf.format(lastDate.getTime());  
        return str;  
    }  
      
    /** 
     * 获取去年的年份 
     *  
     * @return 
     */  
    public static String getLastYear() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
        Calendar c = Calendar.getInstance();  
        c.setTime(currentTime);  
        c.add(Calendar.YEAR, -1);  
        String dateString = formatter.format(c.getTime());  
        return dateString;  
    }  
      
    /** 
     * 获取前年的年份 
     *  
     * @return 
     */  
    public static String getBeforeLastYear() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
        Calendar c = Calendar.getInstance();  
        c.setTime(currentTime);  
        c.add(Calendar.YEAR, -2);  
        String dateString = formatter.format(c.getTime());  
        return dateString;  
    }  
      
    /** 
     * 获取某月最后一天 
     *  
     * @param year 
     * @param month 
     * @return 
     */  
    public static String getLastDayOfMonth(int year, int month) {  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.YEAR, year);  
        cal.set(Calendar.MONTH, month-1);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));  
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());  
    }  
      
    /** 
     * 获取某月第一天 
     * 
     * @param year 
     * @param month 
     * @return 
     */  
    public static String getFirstDayOfMonth(int year, int month) {  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.YEAR, year);  
        cal.set(Calendar.MONTH, month-1);  
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));  
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());  
    }  
      
    /** 
     * 判断日期是否为同一天 
     * 
     * @param dateA 
     * @param dateB 
     * @return true 则为同一天，false则为不在同一天 
     */  
    public static boolean isSameDay(Date dateA,Date dateB) {  
        Calendar calDateA = Calendar.getInstance();  
        calDateA.setTime(dateA);  
  
        Calendar calDateB = Calendar.getInstance();  
        calDateB.setTime(dateB);  
  
        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)  
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)  
                &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);  
    }  
      
    public static void main(String[] args) {  
        System.out.println(getFirstDayOfMonth(2013,2));  
        System.out.println(getLastDayOfMonth(2013,2));  
    }  
}  
