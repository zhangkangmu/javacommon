package 小案例.My学生管理系统.utils;


import 小案例.My学生管理系统.superclass.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangyuhong
 * Date:2017/12/19
 */
public class Utils {
    public static int sId;
    public static int tId;

    static {
        sId = 0;
        tId = 0;
    }

    /**
     * 打印单个学生信息
     *
     * @param person
     */
    public static void printMessage(Person person) throws Exception {
        System.out.println("***********************************************************************");
        System.out.println("id\t\tname\t\tbirthday\t\tage\t\t描述");
        System.out.println(person.getId() + "\t\t" + person.getName() + "\t\t" + person.getSex() + "\t\t"
                + person.getBirthday() + "\t\t" + person.getAge() + "\t\t" + person.describe());
        System.out.println("***********************************************************************");
    }

    /**
     * 打印全部学生信息
     *
     * @param list
     */
    public static void printAllMessage(ArrayList list) throws Exception {
        System.out.println("***********************************************************************");
        System.out.println("id\t\tname\t\tbirthday\t\tage\t\t描述");
        for (int i = 0; i < list.size(); i++) {
            Person person = (Person) list.get(i);
            System.out.println(person.getId() + "\t\t" + person.getName() + "\t\t" + person.getSex() + "\t\t"
                    + person.getBirthday() + "\t\t" + person.getAge() + "\t\t" + person.describe());
        }
        System.out.println("***********************************************************************");
    }


    public static int calculateAge(String age) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = dateFormat.parse(age);
        Calendar birthdayCalendar = Calendar.getInstance();
        birthdayCalendar.setTime(birthdayDate);

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());

        if (nowCalendar.before(birthdayCalendar)) {
            return -1;
        }

        int nowYear = nowCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH);
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);

        int birYear = birthdayCalendar.get(Calendar.YEAR);
        int birMonth = birthdayCalendar.get(Calendar.MONTH);
        int birDay = birthdayCalendar.get(Calendar.DAY_OF_MONTH);

        int ageTotal = nowYear - birYear;

        if (nowMonth < birMonth) {
            ageTotal--;
        } else {
            if (nowMonth == birMonth) {
                if (nowDay < birDay) {
                    ageTotal--;
                }
            }
        }
        return ageTotal;
    }
}
