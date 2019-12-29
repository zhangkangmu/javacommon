package 基础.day06_Collections_Set_Map_斗地主排序.demo2_可变参数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 彭智林
 * @date 2019/12/22 9:35
 */
public class Demo {
    public static void main(String[] args) {
        /*
            可变参数:
                在JDK1.5之后，如果我们定义一个方法需要接受多个参数，并且多个参数类型一致，我们可以对其简化.
                格式:
                    修饰符 返回值类型 方法名(数据类型... 变量名){

                    }
                注意：
                    1.一个方法只能有一个可变参数
                    2.如果方法中有多个参数，可变参数要放到最后。
                应用场景:
                    在Collections中也提供了添加一些元素方法：
                        	public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加一些元素。

         */
        // Collections工具类中的addAll方法
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"2","A","K","Q","J","10","9","8","7","6","5","4","3");
        System.out.println(list);// [2, A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3]



        // 可变参数的语法
        /*int[] arr = {10, 20, 30, 40, 50, 60};

        // 调用method1方法
        method1(10, 20, 30, 40, 50);
        // 调用method2方法
        method2(arr);
        method2(10, 20, 30, 40, 50, 60);
        //
        method3(arr);
        method3(10, 20, 30, 40, 50, 60);

        method4(10,"jack","rose");*/
    }

    public static void method4(int num,String... str){

    }

    // 定义一个方法,可以接收5个int类型的参数
    public static void method3(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(arr[0]);
    }


    // 定义一个方法,可以接收5个int类型的参数
    public static void method2(int... num) {
        for (int i : num) {
            System.out.println(i);
        }
        System.out.println(num[0]);
    }

    // 定义一个方法,可以接收5个int类型的参数
    public static void method1(int num1, int num2, int num3, int num4, int num5) {

    }
}
