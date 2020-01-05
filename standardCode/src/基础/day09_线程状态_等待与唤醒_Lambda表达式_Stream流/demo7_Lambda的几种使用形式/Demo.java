package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo7_Lambda的几种使用形式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 彭智林
 * @date 2017/12/27 12:06
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Lambda表达式其实就是用来替换函数式接口的对象
            Lambda表达式的标准格式
            Lambda表达式的省略格式
            Lambda的几种使用形式: 使用场景
                1.变量的形式:变量的类型为函数式接口类型,那么可以赋值一个Lambda表达式
                2.参数的形式:方法的形参类型为函数式接口类型,那么就可以传入一个Lambda表达式
                3.返回值的形式:方法的返回值类型为函数式接口类型,那么就可以返回一个Lambda表达式

         */
        // 变量的形式:
        Runnable r = ()->{System.out.println("变量的形式");};// 需要Runnable函数式接口的对象,所以可以使用Lambda表达式替换
        r.run();

        // 参数的形式:
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"赵丽颖","马尔扎哈","杨颖","波多野结衣");
        System.out.println("排序之前:"+list);// 排序之前:[赵丽颖, 马尔扎哈, 杨颖, 波多野结衣]
        Collections.sort(list,(String o1,String o2)->{return o2.length() - o1.length();});
        System.out.println("排序之后:"+list);// 排序之后:[波多野结衣, 马尔扎哈, 赵丽颖, 杨颖]
    }

    // 返回值的形式: 方法的返回值类型为函数式接口类型,那么就可以返回一个Lamdba表达式
    public static Comparator<String> getComparator(){
        return ( o1, o2)-> o2.length() - o1.length();
    }

    public static Runnable getRunnable(){
        return ()->{System.out.println("====");};
    }
}
