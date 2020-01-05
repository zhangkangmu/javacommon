package 基础.day06_Collections_Set_Map_斗地主排序.demo10_Map集合的特点;

/**
 * @author 彭智林
 * @date 2017/12/22 11:44
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Map<K,V>集合的特点: K用来限制键的类型,V用来限制值的类型
                1.Map集合存储元素是以键值对的形式存储,每一个键值对都有键和值
                2.Map集合的键是唯一,值可以重复,如果键重复了,那么值就会被覆盖
                3.根据键取值

            Map集合子类:
                - HashMap<K,V>：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。
                                由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。

                - LinkedHashMap<K,V>：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。
                                通过链表结构可以保证元素的存取顺序一致；
                                通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。

                - TreeMap<K,V>：TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；
                                可以对元素的键进行排序，排序方式有两种:自然排序和比较器排序

         */
    }
}
