/**
 * 文件名：DateTest.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java基础 -> 日期
 * 时间：2021-4-7
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateTest {
    /* 程序入口 */
    // 时间原点 0 对应的日期是 1970年1月1日 8点0分0秒 
    public static void main(String[] args) {
        /* Date */
        Date date1 = new Date();    // 返回当前时间
        System.out.println("当前时间:" + date1);
        Date date2 = new Date(5000);    // 从1970年1月1日 早上8点0分0秒 开始经历 5000 毫秒数的时间
        System.out.println("Date(5000)时间:" + date2);
        System.out.println("当前时间getTime()返回的值是："+ date2.getTime());    // 返回毫秒数

        //当前日期的毫秒数
        Date now= new Date();
        System.out.println("Date.getTime() \t\t\t返回值: "+now.getTime());
        //通过System.currentTimeMillis()获取当前日期的毫秒数
        System.out.println("System.currentTimeMillis() \t返回值: "+System.currentTimeMillis());

        /* 日期格式化：SimpleDateFormat 日期格式化类 */
        // 日期转字符串
        // y 代表年、M 代表月、d 代表日、H 代表24进制的小时、h 代表12进制的小时、m 代表分钟、s 代表秒、S 代表毫秒
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        Date d= new Date();
        String str = sdf.format(d);
        System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd" );
        Date d1= new Date();
        String str1 = sdf1.format(d1);
        System.out.println("当前时间通过 yyyy-MM-dd 格式化后的输出: "+str1);

        // 字符串转日期
        SimpleDateFormat sdf3 =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" );
        String str3 = "2016/1/5 12:12:12";
        try {
            Date d3 = sdf3.parse(str3);    // parse() 方法返回 Data 对象
            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s", str3, d3.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Calendar */
        //采用单例模式获取日历对象Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        //通过日历对象得到日期对象
        Date d5 = c.getTime();
        Date d6 = new Date(0);
        c.setTime(d6); //把这个日历，调成日期 : 1970.1.1 08:00:00
        // add方法，在原日期上增加年/月/日
        // set方法，直接设置年/月/日
        // 当前日期
        c.setTime(now);
        System.out.println("当前日期：\t" + c.getTime());
        // 下个月的今天
        c.setTime(now);
        c.add(Calendar.MONTH, 1);
        System.out.println("下个月的今天:\t" + c.getTime());
        // 去年的今天
        c.setTime(now);
        c.add(Calendar.YEAR, -1);
        System.out.println("去年的今天:\t" + c.getTime());
        // 上个月的第三天
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        System.out.println("上个月的第三天:\t" + c.getTime());
    }
}