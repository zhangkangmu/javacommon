package 基础.day03_权限修饰符_代码块_常用API.demo8_Date类;

import java.util.Date;

/**
 * @author 彭智林
 * @date 2019/12/18 10:21
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            知识:
                是什么
                怎么用
                什么时候用

            Date类:
                1.包  java.util 需要导包
                2.概述:java.util.Date类 表示特定的瞬间，精确到毫秒。
                    也就是说Date类表示日期对象,时间精确到毫秒值
                3.构造方法
                    Date()  创建当前系统日期对象
                    Date(long date)  创建以标准基准时间为基准 指定偏移毫秒数 对应的日期对象
                                    标准基准时间:
                                        0时区: 1970年1月1日 00:00:00
                                        东8时区: 1970年1月1日 08:00:00
                                     参数date:偏移毫秒值

                4.成员方法
                    - public long getTime() 获取当前日期对象距离标准基准时间的毫秒值。掌握
                    - public void setTime(long time) 设置当前日期对象距离标准基准时间的毫秒值.也就意味着改变了当前日期对象
         */
        // 创建当前系统日期对象
        Date date1 = new Date();
        System.out.println("date1:"+date1);

        // 创建以标准基准时间为基准 指定偏移毫秒数 对应的日期对象
        Date date2 = new Date(2000);// 1970年1月1日 08:00:02
        System.out.println("date2:"+date2);

        System.out.println("==============================================");
        // 获取date1对象距离标准基准时间的毫秒值。
        long date1Time = date1.getTime();
        System.out.println("date1Time:"+date1Time);// date1Time:1576637585666

        // 获取date2对象距离标准基准时间的毫秒值。
        long date2Time = date2.getTime();
        System.out.println("date2Time:"+date2Time);// date2Time:2000

        System.out.println("==============================================");
        date2.setTime(1000);
        System.out.println("date2:"+date2);
    }
}
