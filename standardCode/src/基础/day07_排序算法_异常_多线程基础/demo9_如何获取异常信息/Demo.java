package 基础.day07_排序算法_异常_多线程基础.demo9_如何获取异常信息;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 彭智林
 * @date 2019/12/24 12:04
 */
public class Demo {
    public static void main(String[] args) {
        /*
            如何获取异常信息:
                Throwable类中定义了一些查看方法:
                    - public String getMessage():获取异常的描述信息,原因(提示给用户的时候,就提示错误原因。
                    - public String toString():获取异常的类型和异常描述信息(不用)。
                    - public void printStackTrace():打印异常的跟踪栈信息并输出到控制台。

         */
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999年10月12日");
            System.out.println(date);
        }catch (Exception e){
           //  e.printStackTrace(); // 打印异常的跟踪栈信息  JVM处理异常就是终止程序运行,打印异常的跟踪栈信息
           // System.out.println(e.getMessage());
            System.out.println(e);
            System.out.println(e.toString());
        }

        System.out.println("结束");

    }
}
