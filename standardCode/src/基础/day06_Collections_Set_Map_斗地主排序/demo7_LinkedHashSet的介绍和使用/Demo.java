package 基础.day06_Collections_Set_Map_斗地主排序.demo7_LinkedHashSet的介绍和使用;

import java.util.LinkedHashSet;

/**
 * @author 彭智林
 * @date 2017/12/22 10:55
 */
public class Demo {
    public static void main(String[] args) {
        /*
            LinkedHashSet的介绍和使用:
                特点:元素无索引,元素存取有序,元素不可重复(唯一)
                保证元素唯一:由哈希表保证元素唯一,哈希表保证元素唯一依赖hashCode()和equals()方法
                保证元素存取有序: 由链表保证元素存取有序
            注意:
                1.Set集合并没有特有的功能,都是使用Collection父接口中的方法
                2.Set集合元素无索引,所以遍历方式只能是:迭代器,增强for循环
         */
        // 创建一个LinkedHashSet集合,限制集合中元素的类型为String
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 往集合中添加元素
        set.add("nba");
        set.add("cba");
        set.add("bac");
        set.add("abc");
        set.add("nba");

        // 遍历打印集合中的元素
        for (String e : set) {
            System.out.println(e);// nba  cba  bac abc
        }

    }
}
