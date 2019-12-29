package 基础.day07_排序算法_异常_多线程基础.demo10_finally代码块;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 彭智林
 * @date 2019/12/24 12:11
 */
public class Demo {
    public static void main(String[] args) {
        /*
            finally代码块:
                finally：有一些特定的代码无论异常是否发生，都需要执行。另外，因为异常会引发程序跳转，导致有些语句执行不到。
                而finally就是解决这个问题的，在finally代码块中存放的代码都是一定会被执行的。

                格式:
                    try{
                        可能会出现异常的代码
                    }catch(异常的类型 变量名){
                        处理异常的代码或者打印异常的信息
                    }finally{
                        无论异常是否发生,都会执行这里的代码(正常情况,都会执行finally中的代码,一般用来释放资源)
                    }
                执行步骤:
                     1.首先执行try中的代码,如果try中的代码出现了异常,那么就直接执行catch()里面的代码,执行完后会执行finally中的代码,然后程序继续往下执行
                     2.如果try中的代码没有出现异常,那么就不会执行catch()里面的代码,但是还是会执行finally中的代码,然后程序继续往下执行
                注意:finally不能单独使用。
         */
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999年10月12日");
            System.out.println(date);
        }catch (Exception e){
            System.out.println("出现了异常....");
        }finally {
            System.out.println("finally中的代码...");
        }
        System.out.println("结束");

        System.out.println("==================================");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999-10-12");
            System.out.println(date);
        }catch (Exception e){
            System.out.println("出现了异常....");
        }finally {
            System.out.println("finally中的代码...");
        }
        System.out.println("结束");

        System.out.println("==================================");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1999-10-12");
            System.out.println(date);
        } catch (ParseException e) {

        } finally {

        }


    }
}
