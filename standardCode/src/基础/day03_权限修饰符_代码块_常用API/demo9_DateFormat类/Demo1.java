package 基础.day03_权限修饰符_代码块_常用API.demo9_DateFormat类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 彭智林
 * @date 2017/12/18 10:57
 */
public class Demo1 {
    public static void main(String[] args) throws ParseException {
        /*
            DateFormat类:
                1.包:java.text  需要导包
                2.概述:DateFormat是一个日期格式化类,抽象类
                3.构造方法:
                    由于DateFormat类是抽象类无法创建对象,所以只能使用其子类SimpleDateFormat
                    SimpleDateFormat类的构造方法:
                        SimpleDateFormat(String pattern);创建一个日期格式化对象
                            参数pattern: 日期格式化的规则
                            常见的格式:  yyyy-MM-dd HH:mm:ss  或者  yyyy年MM月dd日 HH:mm:ss .... 或者yyyy-MM-dd
                            y   年
                            M   月
                            d   日
                            H   时
                            m   分
                            s   秒
                4.成员方法:
                    - 格式化：按照指定的格式，把Date对象转换为String对象。
                           public String format(Date date)：将Date对象格式化为字符串。
                    - 解析：按照指定的格式，把String对象转换为Date对象。
                            public Date parse(String source)：将字符串解析为Date对象。
         */
        // 格式化操作: Date--->String
        /*// 1.创建一个当前系统日期对象
        Date date = new Date();
        // 2.创建日期格式化对象,也就是SimpleDateFormat类的对象,指定格式化的规则
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 3.进行格式化操作
        String dateStr = sdf.format(date);
        System.out.println(dateStr);// 2017-12-18 11:10:30*/


        // 1.创建一个当前系统日期对象
        Date date = new Date();
        // 2.创建日期格式化对象,也就是SimpleDateFormat类的对象,指定格式化的规则
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 3.进行格式化操作
        String dateStr = sdf.format(date);
        System.out.println(dateStr);// 2017-12-18

        System.out.println("=================================");
        // 解析操作: String--->Date
        /*String strDate = "1999-10-12";
        // 创建日期格式化对象,也就是SimpleDateFormat类的对象,指定解析的规则
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        // 进行解析操作
        Date date2 = sdf2.parse(strDate);
        System.out.println(date2);*/


        String strDate = "1999年10月12日";
        // 创建日期格式化对象,也就是SimpleDateFormat类的对象,指定解析的规则
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        // 进行解析操作
        Date date2 = sdf2.parse(strDate);
        System.out.println(date2);

    }
}
