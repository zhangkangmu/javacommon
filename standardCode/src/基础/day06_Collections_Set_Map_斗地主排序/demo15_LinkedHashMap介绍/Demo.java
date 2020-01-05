package 基础.day06_Collections_Set_Map_斗地主排序.demo15_LinkedHashMap介绍;

import java.util.LinkedHashMap;

/**
 * @author 彭智林
 * @date 2017/12/22 15:21
 */
public class Demo {
    public static void main(String[] args) {
        /*
             LinkedHashMap介绍:
                通过链表结构可以保证元素的存取顺序一致；
                通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
         */
        // 创建LinkedHashMap集合对象,限制键的类型为String,值的类型为String
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        // 往map集合中添加键值对
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");
        map.put("谢霆锋", "张柏芝");

        System.out.println(map);// {黄晓明=杨颖, 文章=马伊琍, 谢霆锋=张柏芝}

    }
}
