package 基础.day06_Collections_Set_Map_斗地主排序.demo4_HashSet集合;

import java.util.HashSet;

/**
 * @author 彭智林
 * @date 2019/12/22 9:57
 */
public class Demo {
    public static void main(String[] args) {
        /*
            HashSet集合:元素无索引,元素存取无序,元素不可重复(唯一)
                    存储数据的数据结构是哈希表
         */
        // 1.创建一个HashSet集合,限制集合中的元素类型为String
        HashSet<String> set = new HashSet<>();

        // 2.往集合中添加元素
        set.add("李小龙");
        set.add("甄子丹");
        set.add("成龙");
        set.add("李连杰");
        set.add("甄子丹");
        // 3.打印集合
        System.out.println(set);// [成龙, 李连杰, 李小龙, 甄子丹]
        System.out.println(set.size());// 4


    }
}
