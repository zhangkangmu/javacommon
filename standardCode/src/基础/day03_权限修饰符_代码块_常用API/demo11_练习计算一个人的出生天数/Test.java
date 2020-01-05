package 基础.day03_权限修饰符_代码块_常用API.demo11_练习计算一个人的出生天数;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 彭智林
 * @date 2017/12/18 12:14
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        /*
            练习计算一个人的出生天数:
                思路:
                    1.获得出生日期字符串
                    2.把出生日期字符串转换为Date类型
                    3.获取该出生日期Date对象的毫秒值
                    4.获取当前日期的毫秒值
                    5.2个毫秒值相减即可
                    6.把毫秒值转换为天数
              Scanner类:
               String next();  获取一个字符串  不会获取回车,空格  多次从控制台获取字符串,推荐使用这个
               String nextLine();获取一个字符串,获取回车,空格     获取含有空格,tab键... 推荐使用这个
         */
        while (true) {
            // 1.获得出生日期字符串
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的出生日期,格式为yyyy-MM-dd:");
            String birthdayStr1 = sc.next();

            // 2.把出生日期字符串转换为Date类型
            Date birthdayDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr1);

            // 3.获取该出生日期Date对象的毫秒值
            long birthdayDateTime = birthdayDate.getTime();

            // 4.获取当前日期的毫秒值
            long nowDateTime = new Date().getTime();

            // 5.2个毫秒值相减即可
            long time = nowDateTime - birthdayDateTime;

            // 6.把毫秒值转换为天数
            System.out.println(time/1000/60/60/24);
        }

    }
}
