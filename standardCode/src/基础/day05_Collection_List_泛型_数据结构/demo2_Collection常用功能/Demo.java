package 基础.day05_Collection_List_泛型_数据结构.demo2_Collection常用功能;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author 彭智林
 * @date 2017/12/21 8:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Collection<E>接口 常用功能:
                - public boolean add(E e)：  把给定的对象添加到当前集合中 。
                - public void clear() :清空集合中所有的元素。
                - public int size(): 返回集合中元素的个数。
                - public boolean remove(E e): 把给定的对象在当前集合中删除。
                - public boolean contains(Object obj): 判断当前集合中是否包含给定的对象。
                - public boolean isEmpty(): 判断当前集合是否为空。
                - public Object[] toArray(): 把集合中的元素，存储到数组中
         */
        // 创建一个Collection集合对象,指定集合中元素的类型为String
        Collection<String> coll = new ArrayList<>();

        // 往集合中添加元素: public boolean add(E e)
        coll.add("李冰冰");
        coll.add("范冰冰");
        coll.add("高圆圆");
        coll.add("陈圆圆");
        System.out.println("添加元素后的集合:"+coll);// 添加元素后的集合:[李冰冰, 范冰冰, 高圆圆, 陈圆圆]

        /*// 清空集合中所有的元素:public void clear()
        coll.clear();
        System.out.println("清空所有元素后的集合:"+coll);// 清空所有元素后的集合:[]

        // 统计集合中元素的个数: public int size()
        System.out.println("清空所有元素后的集合大小:"+coll.size());// 清空所有元素后的集合大小:0*/

        // 删除集合中指定元素: public boolean remove(E e)
        // 例如:删除集合中的元素范冰冰
        boolean flag1 = coll.remove("范冰冰");
        System.out.println("flag1:"+flag1);// flag1:true
        System.out.println("删除范冰冰元素后的集合:"+coll);// 删除范冰冰元素后的集合:[李冰冰, 高圆圆, 陈圆圆]

        // 判断集合中是否包含指定的元素:public boolean contains(Object obj)
        // 例如:判断集合中是否包含范冰冰这个元素
        boolean flag2 = coll.contains("范冰冰");
        System.out.println("范冰冰这个元素是否存在:"+flag2);// false

        // 例如:判断集合中是否包含李冰冰这个元素
        boolean flag3 = coll.contains("李冰冰");
        System.out.println("李冰冰这个元素是否存在:"+flag3);// true

        // 判断集合中是否还有元素:public boolean isEmpty()
        boolean flag4 = coll.isEmpty();
        System.out.println("集合中是否还有元素:"+flag4);// false
        /*coll.clear();
        boolean flag5 = coll.isEmpty();
        System.out.println("集合中是否还有元素:"+flag5);// true*/

        // 把集合转换为数组:public Object[] toArray()  本质是:把该集合中的元素存储到一个数组中
        Object[] arr = coll.toArray();
        System.out.println("数组:"+ Arrays.toString(arr));// 数组:[李冰冰, 高圆圆, 陈圆圆]

    }
}
