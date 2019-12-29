package 基础.day05_Collection_List_泛型_数据结构.demo4_增强for循环;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 彭智林
 * @date 2019/12/21 10:01
 */
public class Demo {
    public static void main(String[] args) {
        /*
            增强for循环:
                概述:增强for循环(也称for each循环)是JDK1.5以后出来的一个高级for循环，专门用来遍历数组和集合的。
                    它的内部原理其实是个Iterator迭代器，所以在遍历的过程中，不能对集合中的元素进行增删操作。
                格式:
                    for(元素的数据类型 变量名 : 数组名\集合名){

                    }
                执行流程:
                    1.判断 数组或者集合 中是否有元素可以迭代
                    2.如果有元素可以迭代,就会从这个 数组或者集合中 取出元素赋值给变量
                    3.依次类推,直到没有元素,就自动结束增强for循环
                总结数组和集合的遍历方式:
                    Collection集合: 迭代器,增强for循环
                    List集合: 迭代器,增强for循环,普通for\while循环
                    Set集合:  迭代器,增强for循环
                    数组:增强for循环,普通for\while循环
         */
        // 创建一个Collection集合对象,指定集合中元素的类型为String
        Collection<String> coll = new ArrayList<>();

        // 往集合中添加元素: public boolean add(E e)
        coll.add("李冰冰");
        coll.add("范冰冰");
        coll.add("高圆圆");
        coll.add("陈圆圆");

        // 使用增强for循环遍历coll集合
        for (String str : coll) {
            System.out.println("str:"+str);
        }

        System.out.println("============================");
        String[] arr = {"黄晓明","李连杰","李小龙"};
        for (String str : arr) {
            System.out.println("str:"+str);
        }

    }
}
