package 基础.day06_Collections_Set_Map_斗地主排序.demo8_TreeSet集合的介绍和使用;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 彭智林
 * @date 2017/12/22 11:02
 */
public class Demo {
    public static void main(String[] args) {
        /*
            TreeSet集合:
                特点:
                    1.元素无索引,元素存取无序,元素不可重复(唯一),元素可排序
                    2.存储数据的数据结构:二叉查找树
                    3.由二叉查找树保证元素唯一
                    4.对TreeSet集合中的元素排序由TreeSet构造方法来实现:
                        public TreeSet()：							 根据其元素的默认规则进行排序
                            默认规则:事先在集合元素所属的类中写好的规则
                            对集合中的元素按照默认规则排序,要求该集合元素所属的类实现Comparable接口,重写compareTo()方法
                            然后在compareTo()方法中指定排序的默认规则

                        public TreeSet(Comparator<E> comparator):    根据指定的比较器进行排序
             注意:
                1.TreeSet集合元素无索引,所以遍历方式只能是:迭代器,增强for循环
         */
        // 指定规则排序:
        // 使用有参构造方法创建TreeSet集合对象,限制集合中元素的类型为Integer
        TreeSet<Integer> set2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定排序规则
                // 前减后: 升序
                // 后减前: 降序
                // 前:第一个参数 o1
                // 后:第二个参数 o2
                return o2 - o1;
            }
        });

        // 往集合中添加元素
        set2.add(300);
        set2.add(200);
        set2.add(500);
        set2.add(100);
        set2.add(400);

        // 循环打印集合中的元素
        for (Integer e : set2) {
            System.out.println(e);// 100 200 300 400 500
        }

        System.out.println("=======================================");

        // 默认规则排序:
        // 使用空参构造方法创建TreeSet集合对象,限制集合中元素的类型为Integer
        TreeSet<Integer> set = new TreeSet<>();

        // 往集合中添加元素
        set.add(300);
        set.add(200);
        set.add(500);
        set.add(100);
        set.add(400);

        // 循环打印集合中的元素
        for (Integer e : set) {
            System.out.println(e);// 100 200 300 400 500
        }
    }
}
