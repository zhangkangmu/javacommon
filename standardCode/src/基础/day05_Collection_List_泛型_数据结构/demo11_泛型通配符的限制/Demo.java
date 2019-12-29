package 基础.day05_Collection_List_泛型_数据结构.demo11_泛型通配符的限制;

import java.util.ArrayList;

/**
 * @author 彭智林
 * @date 2019/12/21 11:26
 */
public class Demo {
    public static void main(String[] args) {
        /*
            泛型通配符的限制: 上限和下限
                泛型通配符的上限:  <? extends 数据类型>
                    表示只能接收该类型和该类型的子类类型

                泛型通配符的下限:  <? super 数据类型>
                    表示只能接收该类型和该类型的父类类型
         */
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Number> list4 = new ArrayList<>();

        // method(list1);// 编译报错
        // method(list2);// 编译报错
        method(list3);
        method(list4);

        System.out.println("======================");
        // method2(list1);// 编译报错
        method2(list2);
        method2(list3);
        method2(list4);

    }

    // 定义一个方法,方法的参数类型为ArrayList类型,该参数要接收: ArrayList<Integer>,  ArrayList<Number>
    public static void method(ArrayList<? extends Number> list){
        for (Object obj : list) {
            System.out.println(obj);
        }
    }


    // 定义一个方法,方法的参数类型为ArrayList类型,该参数要接收: ArrayList<Integer>,  ArrayList<Number>, ArrayList<Object>
    public static void method2(ArrayList<? super Integer> list){
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
