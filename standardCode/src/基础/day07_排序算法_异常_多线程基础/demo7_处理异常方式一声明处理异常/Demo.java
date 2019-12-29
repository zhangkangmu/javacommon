package 基础.day07_排序算法_异常_多线程基础.demo7_处理异常方式一声明处理异常;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author 彭智林
 * @date 2019/12/24 11:20
 */
public class Demo {
    public static void main(String[] args) throws IOException{
        /*
            处理异常方式一:声明处理异常
                声明处理异常的概述: 将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，
                而没有捕获处理（稍后讲解该方式），那么必须通过throws进行声明，让调用者去处理。
                声明处理异常的格式:
                    修饰符 返回值类型 方法名(形参列表) throws 异常类型1,异常类型2,....{

                    }

               注意:
                1. 关键字throws运用于方法声明之上,用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常).
                2. throws用于进行异常类的声明，若该方法可能有多种异常情况产生，那么在throws后面可以写多个异常类，用逗号隔开。
                3. throws用于进行异常类的声明，若该方法可能有多种异常情况产生，那么在throws后面可以直接所有异常的父类。
         */
        method1();
    }

    public static void method3(int num) throws Exception {
        if(num == 1) {
            throw new IOException("IO异常");// 创建了一个编译异常,并通过throw抛出这个编译异常
        }else{
            throw new ParseException("解析异常",1);
        }
    }

    public static void method2(int num) throws IOException,ParseException{
        if(num == 1) {
            throw new IOException("IO异常");// 创建了一个编译异常,并通过throw抛出这个编译异常
        }else{
            throw new ParseException("解析异常",1);
        }
    }


    public static void method1() throws IOException{
        throw new IOException("IO异常");// 创建了一个编译异常,并通过throw抛出这个编译异常
    }
}
