package 基础.day06_Collections_Set_Map_斗地主排序.demo12_Map遍历方式一;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 彭智林
 * @date 2019/12/22 14:51
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Map遍历方式一:根据键找值的方式
                1.获取集合中所有的键  Set<K> keySet()方法
                2.遍历所有的键的集合
                3.在循环中,根据键找值 V get(K key)方法
         */
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();
        // 往map集合中添加键值对
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 遍历map集合
        // 获取集合中所有的键  Set<K> keySet()方法
        Set<String> keys = map.keySet();
        // 遍历所有的键的集合
        for (String key : keys) {
            // 在循环中,根据键找值 V get(K key)方法
            String value = map.get(key);
            System.out.println("键:"+key+",值:"+value);
        }
    }
}
