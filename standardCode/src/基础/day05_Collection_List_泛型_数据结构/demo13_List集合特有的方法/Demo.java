package 基础.day05_Collection_List_泛型_数据结构.demo13_List集合特有的方法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭智林
 * @date 2017/12/21 15:43
 */
public class Demo {
    public static void main(String[] args) {
        /*
            List集合特有的方法：增删查改
                - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
                - public E get(int index):返回集合中指定位置的元素。
                - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
                - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
         */
        // 创建一个List集合,限制集合中的元素为String类型
        List<String> list = new ArrayList<>();

        // 往集合中添加一些元素
        list.add("苍老师");
        list.add("波老师");
        list.add("吉泽老师");
        list.add("小泽老师");
        System.out.println(list);// [苍老师, 波老师, 吉泽老师, 小泽老师]

        // 添加元素到集合的指定位置:public void add(int index, E element)
        // 例如:在索引为1的位置添加一个元素(王老师)
        list.add(1,"王老师");
        System.out.println(list);// [苍老师, 王老师, 波老师, 吉泽老师, 小泽老师]

        // 获取指定索引位置上的元素: public E get(int index)
        // 例如:获取索引为2的元素
        String e1 = list.get(2);
        System.out.println("索引为2的元素是:"+e1);// 索引为2的元素是:波老师

        // 删除指定索引位置上的元素:public E remove(int index)
        // 例如:删除索引为1的元素
        String removeE = list.remove(1);
        System.out.println("被删除的元素:"+removeE);// 被删除的元素:王老师
        System.out.println(list);// [苍老师, 波老师, 吉泽老师, 小泽老师]

        // 修改指定位置上的元素:public E set(int index, E element)
        // 例如:把索引为0的元素替换为明老师
        String e2 = list.set(0, "明老师");
        System.out.println("被替换的元素:"+e2);// 被替换的元素:苍老师
        System.out.println(list);// [明老师, 波老师, 吉泽老师, 小泽老师]
    }
}
