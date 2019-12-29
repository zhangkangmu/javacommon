package 基础.day06_Collections_Set_Map_斗地主排序.demo13_Map遍历方式二;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 彭智林
 * @date 2019/12/22 14:56
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Entry<K,V>接口:简称Entry项,表示键值对对象,用来封装Map集合中的键值对
            Entry<K,V>接口:是Map接口中的内部接口,在外部使用的时候是这样表示: Map.Entry<K,V>

            Map集合中提供了一个方法来获取所有键值对对象:
                public Set<Map.Entry<K,V>> entrySet()

            根据键值对对对象获取键和值:
                - public K getKey()：获取Entry对象中的键。
                - public V getValue()：获取Entry对象中的值。

            Map遍历方式二:根据键值对对象的方式
                1.获取集合中所有键值对对象  Set<Map.Entry<K,V>> entrySet()
                2.遍历所有键值对对象的集合
                3.在循环中,可以使用键值对对对象获取键和值   getKey()和getValue()
         */
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();
        // 往map集合中添加键值对
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 获取集合中所有键值对对象  Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        // 遍历所有键值对对象的集合
        for (Map.Entry<String, String> entry : entrySet) {
            // 在循环中,可以使用键值对对对象获取键和值   getKey()和getValue()
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("键:"+key+",值:"+value);
        }
    }
}
