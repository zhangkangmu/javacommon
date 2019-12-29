package 基础.day07_排序算法_异常_多线程基础.demo8_处理异常方式二捕获处理异常;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 彭智林
 * @date 2019/12/24 11:49
 */
public class Demo {
    public static void main(String[] args) {
        /*
            处理异常方式二捕获处理异常: try-catch的方式就是捕获异常。
                捕获异常：Java中对异常有针对性的语句进行捕获，可以对出现的异常进行指定方式的处理。
                格式:
                    try{
                        可能会出现异常的代码
                    }catch(异常的类型 变量名){
                        处理异常的代码或者打印异常的信息
                    }
                执行步骤:
                    1.首先执行try中的代码,如果try中的代码出现了异常,那么就直接执行catch()里面的代码,执行完后,程序继续往下执行
                    2.如果try中的代码没有出现异常,那么就不会执行catch()里面的代码,而是继续往下执行
                注意:
                    1.try和catch都不能单独使用,必须连用。
                    2.try中的代码出现了异常,那么出现异常位置后面的代码就不会再执行了
                    3.捕获处理异常,如果程序出现了异常,程序会继续往下执行
                      声明处理异常,如果程序出现了异常,程序就不会继续往下执行
         */
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999年10月12日");
            System.out.println(date);
        }catch (Exception e){
            System.out.println("出现了异常....");
        }
        System.out.println("结束");

       /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1999-10-12");
        System.out.println(date);*/
    }
}
