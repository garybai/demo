package com.example.unnameddemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Gary
 * @className DateTest
 * @description TODO
 * @date 2019-07-29 19:30
 **/
public class DateTest {
    public static Date geLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);

        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }

        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public static void main(String[] args) {
        String today = "2019-09-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(today);
            System.out.println("当天是：" + today);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, 100);
            Date date100 = cal.getTime();
            System.out.println("100天后是：" + sdf.format(date100));
//            System.out.println("今天是" + sdf.format(date));
//            System.out.println("上周一" + sdf.format(geLastWeekMonday(date)));
//            System.out.println("本周一" + sdf.format(getThisWeekMonday(date)));
            System.out.println("100天后的下周一是：" + sdf.format(getNextWeekMonday(date100)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
