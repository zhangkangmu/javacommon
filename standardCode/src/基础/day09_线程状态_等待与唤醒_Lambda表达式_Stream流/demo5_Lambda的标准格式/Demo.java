package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo5_Lambda的标准格式;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 彭智林
 * @date 2019/12/27 11:23
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Lambda的标准格式:
                (数据类型 参数名)->{ 需要执行的代码 }

              格式说明:
                - 小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
                - ->是新引入的语法格式，代表指向动作。
                - 大括号内的语法与传统方法体要求基本一致。

              补充:
                小括号中的内容和函数式接口中抽象方法的小括号内容一致,参数名可以不一致,参数类型,参数个数,参数顺序必须一致
                大括号中的内容和以前实现函数式接口抽象方法的方法体一致
                Lambda表达式大括号中的代码是调用了该函数式接口的抽象方法才会执行

              使用Lambda表达式的前提: 接口为函数式接口,也就是接口中有且仅有一个抽象方法
              常见的函数式接口: Runnable  Comparable Comparator Callable ....


              案例:
                案例1: 接口中的方法是“无参、无返回值”的： Runnable
                案例2: 接口中的方法是“有参、有返回值”的： Comparator
         */
        // 案例1:
       /* new Thread(()->{
            // 线程需要执行的任务
            for (int i = 0; i < 100; i++) {
                System.out.println("任务 i循环第"+i+"次循环");
            }

        }).start();*/

        // 案例2:Collections工具类中的sort方法会使用Comparator函数式接口 int compare(T t1,T t2);
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"赵丽颖","马尔扎哈","杨颖","波多野结衣");
        System.out.println("排序之前:"+list);// 排序之前:[赵丽颖, 马尔扎哈, 杨颖, 波多野结衣]

        // 使用Collections工具类中的sort方法对list集合按照元素的长度进行降序排序
        // 匿名内部类:
        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 后减前
                return o2.length() - o1.length();
            }
        });*/
        // Lambda表达式:
        Collections.sort(list,(String o1, String o2)->{return o2.length() - o1.length(); });
        System.out.println("排序之后:"+list);// 排序之后:[波多野结衣, 马尔扎哈, 赵丽颖, 杨颖]
    }

}
