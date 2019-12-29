package 基础.day03_权限修饰符_代码块_常用API.demo19_包装类的使用;

import java.util.ArrayList;

/**
 * @author 彭智林
 * @date 2019/12/18 16:52
 */
public class Demo {
    public static void main(String[] args) {
        /*
            ArrayList<E>类:集合类
                <E>:表示泛型,用来限制集合中元素的类型,E这个位置只能写引用数据类型,不能写基本数据类型

            使用集合的时候,如果集合中要存储基本数据类型,那么就需要把基本数据类型包装为对应的包装类类型
         */
        // 创建一个集合,用来存储多个整数,限制集合中元素的类型为Integer类型
        ArrayList<Integer> list1 = new ArrayList<>();
        // 往集合中存储整数
        list1.add(100);
        list1.add(200);
        list1.add(300);
        // list1.add("400");
        System.out.println(list1.size());// 3
        System.out.println(list1);// [100, 200, 300]

       /* // 创建一个集合,用来存储多个数据,限制集合中的元素只能是String类型
        ArrayList<String> list1 = new ArrayList<String>();
        // 往集合中添加数据
        list1.add("张三丰");
        list1.add("张翠山");
        list1.add("张无忌");
        *//*list1.add(100);
        list1.add(3.14);*//*
        System.out.println(list1.size());// 3
        System.out.println(list1);// [张三丰, 张翠山, 张无忌]*/


       /* // 创建一个集合,用来存储多个数据,元素默认类型是Object类型
        ArrayList list1 = new ArrayList();
        // 往集合中添加数据
        list1.add("张三丰");
        list1.add("张翠山");
        list1.add("张无忌");
        list1.add(100);
        list1.add(3.14);
        System.out.println(list1.size());// 5
        System.out.println(list1);// [张三丰, 张翠山, 张无忌, 100, 3.14]*/
    }
}
