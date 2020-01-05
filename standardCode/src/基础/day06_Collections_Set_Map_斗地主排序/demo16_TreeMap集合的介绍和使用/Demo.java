package 基础.day06_Collections_Set_Map_斗地主排序.demo16_TreeMap集合的介绍和使用;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 彭智林
 * @date 2017/12/22 15:25
 */
public class Demo {
    public static void main(String[] args) {
        /*
            TreeMap<K,V>：TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；
                          可以对元素的键进行排序，排序方式有两种:自然排序和比较器排序

                 构造方法:
                    public TreeMap()									使用默认规则排序
                    默认规则:事先在键所属的类中写好的规则
                     对集合中的键按照默认规则排序,要求该集合的键所属的类实现Comparable接口,重写compareTo()方法
                    然后在compareTo()方法中指定排序的默认规则

                    public TreeMap(Comparator<? super K> comparator) 	指定规则排序

         */
        // 指定规则排序:
        // 使用有参构造方法创建TreeMap集合,指定键的类型为Integer,值的类型为String
        TreeMap<Integer,String> map2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定排序规则: 降序
                // 前减后 升序
                // 后减前 降序
                // 前: 第一个参数  o1
                // 后: 第二个参数  o2
                return o2 - o1;
            }
        });

        // 往集合中添加键值对
        map2.put(1,"张三丰");
        map2.put(3,"张无忌");
        map2.put(2,"张翠山");
        map2.put(4,"张翠红");

        // 打印集合
        System.out.println(map2);

        System.out.println("===========================");

        // 默认规则排序:
        // 使用空参构造方法创建TreeMap集合,指定键的类型为Integer,值的类型为String
        TreeMap<Integer,String> map = new TreeMap<>();

        // 往集合中添加键值对
        map.put(1,"张三丰");
        map.put(3,"张无忌");
        map.put(2,"张翠山");
        map.put(4,"张翠红");

        // 打印集合
        System.out.println(map);
    }
}
