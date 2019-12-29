package 基础.day04_综合练习_管理系统.utils;


import 基础.day04_综合练习_管理系统.superclass.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 彭智林
 * @date 2019/12/19 9:46
 */
public class Utils {
    public static int sid ;
    public static int tid ;

    static {
        sid = 0;
        tid = 0;
        // 后期从文件中读取值来初始化
    }

    /**
     * 根据传入的出生日期计算年龄
     * @param birthday
     * @return
     */
    public static int birthdayToAge(String birthday){
        // 思路:
        // 0.把字符串类型的出生日期转换为日历对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = null;
        try {
            birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(birthdayDate);

        // 1.获取当前日历对象
        Calendar nowCal = Calendar.getInstance();

        // 2.判断出生日期是否在当前日期之前,如果不在当前日期之前,就直接返回-1,结束方法  Calendar类:before方法
        if (nowCal.before(cal1)){
            return -1;
        }

        // 3.根据出生日期的日历对象获取出生的年月日
        int birthdayYear = cal1.get(Calendar.YEAR);
        int birthdayMonth = cal1.get(Calendar.MONTH);
        int birthdayDay = cal1.get(Calendar.DAY_OF_MONTH);

        // 4.获取当前的年月日
        int nowYear = nowCal.get(Calendar.YEAR);
        int nowMonth = nowCal.get(Calendar.MONTH);
        int nowDay = nowCal.get(Calendar.DAY_OF_MONTH);

        // 5.使用当前的年份减去出生的年份,得到一个初步的年龄
        int age = nowYear - birthdayYear;

        // 6.判断是否过了生日,如果没有过生日,那么初步年龄-1,如果已经过生日,年龄就是初步计算出来的年龄
        if(birthdayMonth > nowMonth){// 月份没到
            age--;
        }

        if((birthdayMonth == nowMonth) && (birthdayDay > nowDay)){// 月份到了,日期没到
            age--;
        }
        return age;
    }

    /**
     * 指定格式打印Person对象
     * @param p
     */
    public static void printPerson(Person p){
        System.out.println(p.getId() + "\t\t" +
                p.getName() + "\t\t" +
                p.getSex() + "\t\t" +
                p.getBirthday() + "\t\t" +
                p.getAge() + "\t\t" +
                "我是一名:" + p.getType() + ",我的工作是:" + p.getWork()
        );
    }

    /**
     * 指定格式打印集合中的元素
     * @param list
     */
    public static void printArrayList(ArrayList list){
        System.out.println("*********************************************************************");
        System.out.println("id\t\tname\tsex\t\tbirthday\t\tage\t\t描述");
        for (int i = 0; i < list.size(); i++) {
            // 获取集合中的学生对象
            Person p = (Person) list.get(i);
            Utils.printPerson(p);
        }
        System.out.println("*********************************************************************");

    }
}
