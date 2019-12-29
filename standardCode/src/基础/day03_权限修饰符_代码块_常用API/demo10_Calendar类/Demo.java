package 基础.day03_权限修饰符_代码块_常用API.demo10_Calendar类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 彭智林
 * @date 2019/12/18 11:17
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        /*
            Calendar类:
                1.包:java.util  需要导包
                2.概述:Calendar类是一个日历抽象类,表示日历对象
                3.构造方法:
                    因为Calendar类是一个抽象类,不能直接创建对象,只能创建其子类对象.
                    GregorianCalendar类是Calendar的子类:
                        通过GregorianCalendar类的构造方法创建日历对象:
                                GregorianCalendar() 创建当前日历对象
                        通过Calendar类的静态方法直接获取:   推荐
                                static Calendar getInstance()
                4.成员方法:
                    public int get(int field) 获取某个字段的值。
                                   参数field:表示获取哪个字段的值,可以使用Calender中定义的常量来表示
                    public void set(int field,int value) 设置某个字段的值
                    public void add(int field,int amount)为某个字段增加/减少指定的值

                   额外增加:
                    void setTime(Date date)  使用给定的 Date 设置此 Calendar 的时间。
                    boolean before(Object when) 判断此 Calendar 表示的时间是否在指定 Object 表示的时间之前，返回判断结果。
                                调用before方法的日历对象是否在参数时间对象之前,
                                    如果在之前就返回true     例如: 2017年11月11日   2019年12月18日   true
                                    如果不在之前就返回false  例如: 2019年12月18日    2017年11月11日  false
                注意:
                    1.中国人:一个星期的第一天是星期一,外国人:一个星期的第一天是星期天
                    2.日历对象中的月份是: 0-11
                    String ---> Date ---> Calendar
         */
        // 获取当前日期的日历对象
        Calendar nowCal = Calendar.getInstance();//  2019年12月18日

        // 出生日期的日历对象
        String birtday = "2017年11月11日";
        // 创建日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        // 把String转换为Date
        Date birthdayDate = sdf.parse(birtday);
        // 把出生日期Date对象  转换为 Calendar日历对象
        Calendar birthdayCal = Calendar.getInstance();
        birthdayCal.setTime(birthdayDate);

        // 比较当前日历对象nowCal  与 出生日期日历对象 birthdayCal
        System.out.println(birthdayCal.before(nowCal));// true
        System.out.println(nowCal.before(birthdayCal));// false

    }

    /**
     * setTime方法
     */
    private static void method02() {
        // 获取日历对象
        Calendar cal1 = Calendar.getInstance();
        System.out.println(cal1);// 当前日期对应的日历对象
        /*
            java.util.GregorianCalendar[time=1576641557775,areFieldsSet=true,areAllFieldsSet=true,
            lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,
            dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,
            minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=11,WEEK_OF_YEAR=51,WEEK_OF_MONTH=3,
            DAY_OF_MONTH=18,DAY_OF_YEAR=352,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=3,AM_PM=0,HOUR=11,
            HOUR_OF_DAY=11,MINUTE=59,SECOND=17,MILLISECOND=775,ZONE_OFFSET=28800000,DST_OFFSET=0]

         */

        // 设置指定的Date为cal1日历对象的时间
        Date date = new Date(1000);// 1970-01-01 08:00:01
        cal1.setTime(date);
        System.out.println(cal1);
        /*
            java.util.GregorianCalendar[time=1000,areFieldsSet=true,areAllFieldsSet=true,
            lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,
            dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,
            minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,
            DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=8,
            HOUR_OF_DAY=8,MINUTE=0,SECOND=1,MILLISECOND=0,ZONE_OFFSET=28800000,DST_OFFSET=0]

         */
    }

    private static void method01() {
        // 获取日历对象
        GregorianCalendar cal1 = new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal1);
        System.out.println(cal2);
        /*
            java.util.GregorianCalendar[time=1576639674053,areFieldsSet=true,areAllFieldsSet=true,
            lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,
            dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,
            minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=11,WEEK_OF_YEAR=51,WEEK_OF_MONTH=3,
            DAY_OF_MONTH=18,DAY_OF_YEAR=352,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=3,AM_PM=0,HOUR=11,
            HOUR_OF_DAY=11,MINUTE=27,SECOND=54,MILLISECOND=53,ZONE_OFFSET=28800000,DST_OFFSET=0]
         */

        // 分别日历对象中的关于时间的信息
        // 获取日历字段中的年
        int year = cal2.get(Calendar.YEAR);
        System.out.println("年:"+year);// 年:2019

        // 获取日历字段的月
        int month = cal2.get(Calendar.MONTH);
        System.out.println("月:"+(month+1));// 12
        System.out.println("日:"+cal2.get(Calendar.DAY_OF_MONTH));//18

        System.out.println("=============================");
        // 修改cal2日历对象中的年为2099
        cal2.set(Calendar.YEAR,2099);
        System.out.println("修改后的年:"+cal2.get(Calendar.YEAR));// 修改后的年:2099

        // 修改cal2日历对象中的月份为12
        // cal2.set(Calendar.MONTH,12);
        // System.out.println("修改后的月:"+cal2.get(Calendar.MONTH));// 0

        System.out.println("=============================");
        // 为cal2日历对象中的年增加2年
        cal2.add(Calendar.YEAR,2);
        System.out.println("增加2年后的年:"+cal2.get(Calendar.YEAR));// 增加2年后的年:2101

        // 为cal2日历对象中的年减少5年
        cal2.add(Calendar.YEAR,-5);
        System.out.println("减少5年后的年:"+cal2.get(Calendar.YEAR));// 减少5年后的年:2096
    }
}
