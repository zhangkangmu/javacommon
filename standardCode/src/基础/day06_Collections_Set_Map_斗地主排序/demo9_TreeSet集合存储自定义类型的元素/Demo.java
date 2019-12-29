package 基础.day06_Collections_Set_Map_斗地主排序.demo9_TreeSet集合存储自定义类型的元素;

import java.util.TreeSet;

/**
 * @author 彭智林
 * @date 2019/12/22 11:14
 */
public class Demo {
    public static void main(String[] args) {
        /*
            TreeSet集合存储自定义类型的元素:
                使用TreeSet的空参构造方法对集合中自定义类型的元素按照默认规则排序,那么就要求该集合中元素所属的类实现Comparable接口
                重写compareTo()方法,然后在compareTo()方法中指定排序的默认规则
         */
        // 创建多个Person对象
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("李四", 38);
        Person p3 = new Person("王五", 28);
        Person p4 = new Person("张三", 18);

        // 使用空参构造方法创建TreeSet集合对象,限制集合中元素的类型为Person
        TreeSet<Person> set = new TreeSet<>();
        // 往集合中添加Person对象
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        // 循环遍历打印元素
        for (Person p : set) {
            System.out.println(p);
        }
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
    }
}
