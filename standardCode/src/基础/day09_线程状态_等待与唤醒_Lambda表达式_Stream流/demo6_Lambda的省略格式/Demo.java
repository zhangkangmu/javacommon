package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo6_Lambda的省略格式;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 彭智林
 * @date 2019/12/27 11:23
 */
public class Demo {
    public static void main(String[] args) {
        /*
            demo6_Lambda的省略格式:
                - 小括号内参数的类型可以省略；
                - 如果小括号内有且仅有一个参数，则小括号和参数类型可以一起省略；
                - 如果大括号内有且仅有一条语句，则可以同时省略：一对大括号，语句后的分号，return关键字；

              案例:
                案例1: 接口中的方法是“无参、无返回值”的： Runnable
                案例2: 接口中的方法是“有参、有返回值”的： Comparator
         */
        // 案例1:
        // 标准格式:
       new Thread(()-> {
           // 线程需要执行的任务
           System.out.println("任务 ");

       }).start();
       // 省略格式:
        new Thread(()-> System.out.println("任务!")).start();

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
        // Lambda表达式:标准格式
        // Collections.sort(list,(String o1, String o2)->{return o2.length() - o1.length(); });
        Collections.sort(list,( o1,  o2)-> o2.length() - o1.length());
        System.out.println("排序之后:"+list);// 排序之后:[波多野结衣, 马尔扎哈, 赵丽颖, 杨颖]
    }

}
