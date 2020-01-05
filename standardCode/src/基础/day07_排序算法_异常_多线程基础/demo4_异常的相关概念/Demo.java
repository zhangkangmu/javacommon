package 基础.day07_排序算法_异常_多线程基础.demo4_异常的相关概念;

import java.text.ParseException;

/**
 * @author 彭智林
 * @date 2017/12/24 10:25
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        /*
            异常的概念:指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止。
            注意:
                在Java等面向对象的编程语言中，异常本身是一个类，产生异常就是创建异常对象并抛出了一个异常对象。
                JVM处理异常的方式是中断处理。
            异常的体系:
                Throwable类:异常的顶层父类,Java 语言中所有错误或异常的超类
                    Error类:严重错误Error，无法通过代码来处理错误，只能事先避免，好比绝症。
                            例如:数据库奔溃,服务器宕机....
                    Exception类:表示异常，异常产生后程序员可以通过代码的方式纠正，使程序继续运行，是必须要处理的。好比感冒、阑尾炎。
            异常的分类:
                编译异常:在编译期间出现的异常,如果在编译期间不处理,无法通过编译,更加无法运行
                    除了RuntimeException及其子类都是表示编译异常

                运行异常:在运行期间出现的异常,如果在编译期间不处理,可以通过编译,也可以运行,只不过在运行的时候,如果出现异常,就会终止程序
                    RuntimeException及其子类表示运行异常

         */

        int[] arr = {10,20,30,40};
        getArrayElement(arr,4);
    }

    public static void getArrayElement(int[] arr,int index){
        int element = arr[index];
        System.out.println("索引为"+index+"的元素是:"+element);
    }
}
