package 基础.day05_Collection_List_泛型_数据结构.demo10_泛型通配符;

import java.util.ArrayList;

/**
 * @author 彭智林
 * @date 2017/12/21 11:16
 */
public class Demo {
    public static void main(String[] args) {
        /*
            泛型的通配符:不知道使用什么类型来接收的时候,此时可以使用?,?表示未知通配符。
            注意:
                1.泛型没有多态
                2.- 一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用。
         */
        // String和Number都是继承Object,而Integer继承Number
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Number> list4 = new ArrayList<>();

        /*ArrayList<?> listA = list1;// list2,list3,list4
        ArrayList<?> listB = list2;// list2,list3,list4
        ArrayList<?> listC = list3;// list2,list3,list4
        ArrayList<?> listD = list4;// list2,list3,list4*/

        method(list1);
        method(list2);
        method(list3);
        method(list4);

    }

    // 定义一个方法,方法的参数类型为ArrayList类型,该参数要接收: ArrayList<String>,ArrayList<Object>, ArrayList<Integer>,  ArrayList<Number>
    public static void method(ArrayList<?> list){
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}
