package 基础.day06_Collections_Set_Map_斗地主排序.demo6_HashSet存储自定义类型元素;

import java.util.HashSet;

/**
 * @author 彭智林
 * @date 2017/12/22 10:41
 */
public class Demo {
    public static void main(String[] args) {
        /*
            HashSet存储自定义类型元素:
                给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保证HashSet集合中的对象唯一.

         */
        // 创建多个Person对象
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("李四", 38);
        Person p3 = new Person("王五", 28);
        Person p4 = new Person("张三", 18);
        // 创建HashSet集合对象,限制集合中元素的类型为Person
        HashSet<Person> set = new HashSet<>();

        // 往集合中添加Person对象
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        // 遍历打印集合中的元素
        for (Person p : set) {
            System.out.println(p);
        }

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
    }
}
