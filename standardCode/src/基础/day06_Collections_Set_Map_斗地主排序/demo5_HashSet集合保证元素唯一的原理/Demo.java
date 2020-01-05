package 基础.day06_Collections_Set_Map_斗地主排序.demo5_HashSet集合保证元素唯一的原理;

import java.util.HashSet;

/**
 * @author 彭智林
 * @date 2017/12/22 10:05
 */
public class Demo {
    public static void main(String[] args) {
        /*
            HashSet集合保证元素唯一:因为存储数据的数据结构为哈希表,由哈希表保证元素唯一
            HashSet集合保证元素唯一的原理:哈希表保证元素唯一依赖于hashCode()和equals方法();
                1.当HashSet集合存储元素的时候,就会调用该元素的hashCode()方法计算哈希值
                2.判断该哈希值位置上,是否有相同哈希值的元素
                3.如果该哈希值位置上没有相同哈希值的元素,那么就直接存储
                4.如果该哈希值位置上有相同哈希值的元素,那么就产生了哈希冲突
                5.如果产生了哈希冲突,就得调用该元素的equals()方法与该哈希值位置上的所有元素进行一一比较:
                  如果该哈希值位置上有任意一个元素与该元素相等,那么就不存储
                  如果该哈希值位置上所有元素与该元素都不相等,那么就直接存储

            补充:
                Object类: hashCode()和equals()方法;
                    hashCode():Object类中的hashCode()方法是根据地址值计算哈希值
                    equals方法():Object类中的equals()方法是比较地址值
         */
        // 创建一个HashSet集合,限制集合中元素的类型为String
        HashSet<String> set = new HashSet<>();

        // 往集合中添加一些元素
        set.add("nba");
        set.add("cba");
        set.add("bac");
        set.add("abc");
        set.add("nba");

        // 遍历打印集合
        for (String e : set) {
            System.out.println(e);// cba abc  bac  nba
        }

        System.out.println("nba".hashCode());// nba:108845
        System.out.println("cba".hashCode());// cba:98274
        System.out.println("bac".hashCode());// bac:97284
        System.out.println("abc".hashCode());// abc:96354

    }
}
