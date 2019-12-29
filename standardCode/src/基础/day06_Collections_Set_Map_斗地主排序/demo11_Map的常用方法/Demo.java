package 基础.day06_Collections_Set_Map_斗地主排序.demo11_Map的常用方法;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 彭智林
 * @date 2019/12/22 11:54
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Map<K,V>的常用方法:
                - public V put(K key, V value):  往集合中添加键值对,返回被替换的值
                - public V remove(Object key): 删除指定的键对应的键值对，返回被删除元素的值。
                - public V get(Object key) 根据指定键找到对应的值
                - public boolean containKey(Object key):判断该集合中是否有此键。
                - public boolean containsValue(Object value) :判断该集合中是否有此值。
                - public  int size() : 计算集合中键值对的个数

                - public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
                - public  Collection<V> values():  获取Map集合中所有的值，存储到Collection集合中。

                - public Set<Map.Entry<K,V>> entrySet(): 获取到Map集合中所有的键值对对象的集合(Set集合)。
                    Map集合中的一个元素是包含键对象和值对象,是2个对象,在java中如果要封装这种键值对对象,那么就得
                    使用Entry类型来表示,也就是说Entry类型是表示键值对对象的
                    Entry<K,V>接口:定义在Map接口中的内部接口,所以表示Entry<K,V>接口类型,就得这么写:Map.Entry<K,V>
                    Map.Entry<K,V>: 表示键值对对象类型

                    Map.Entry<K,V>: 键值对对象类型
                    键值对:有2个对象
                    键值对对象:1个对象

             HashMap集合:键值对存取无序
         */
        Map<String, String> map = new HashMap<>();

        // 往Map集合中添加键值对:public V put(K key, V value)
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 获取map集合中所有的键值对对象: public Set<Map.Entry<K,V>> entrySet()
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        for(Map.Entry<String, String> entry : entrySet){
            System.out.println(entry);// 文章=马伊琍  谢霆锋=王菲  黄晓明=杨颖
        }

    }

    /**
     * public Set<K> keySet()
     * public  Collection<V> values()
     */
    private static void method04() {
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();

        // 往Map集合中添加键值对:public V put(K key, V value)
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 获取所有的键,存储到Set集合中:public Set<K> keySet()
        Set<String> keys = map.keySet();
        System.out.println(keys);// [文章, 谢霆锋, 黄晓明]

        // 获取所有的值,存储到Collection集合中:public  Collection<V> values()
        Collection<String> values = map.values();
        System.out.println(values);// [马伊琍, 王菲, 杨颖]
    }

    /**
     * public boolean containKey(Object key)
     * public boolean containsValue(Object value)
     */
    private static void method03() {
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();

        // 往Map集合中添加键值对:public V put(K key, V value)
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 判断map集合中是否包含黄晓明这个键: public boolean containKey(Object key)
        System.out.println(map.containsKey("黄晓明"));// true
        System.out.println(map.containsKey("李亚鹏"));// false

        // 判断map集合中是否包含姚笛这个值:public boolean containValue(Object key)
        System.out.println(map.containsValue("姚笛"));// false
        System.out.println(map.containsValue("马伊琍"));// true
    }

    /**
     * public V remove(Object key)
     * public V get(Object key)
     */
    private static void method02() {
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();

        // 往Map集合中添加键值对:public V put(K key, V value)
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("谢霆锋", "王菲");

        // 删除文章这个键对应的键值对:public V remove(Object key)
        String value = map.remove("文章");
        System.out.println("value:" + value);// value:马伊琍
        System.out.println(map);// {谢霆锋=王菲, 黄晓明=杨颖}

        // 查找黄晓明这个键对应的值:public V get(Object key)
        String value1 = map.get("黄晓明");
        System.out.println("value1:" + value1);// value1:杨颖

        // 查找文章这个键对应的值:public V get(Object key)
        String value2 = map.get("文章");
        System.out.println("value2:" + value2);// value2:null
    }

    /**
     * public V put(K key, V value):  往集合中添加键值对,返回被替换的值
     * public  int size() : 计算集合中键值对的个数
     */
    private static void method01() {
        // 创建Map集合对象,限制键的类型为String,值的类型为String
        Map<String, String> map = new HashMap<>();

        // 往Map集合中添加键值对:public V put(K key, V value)
        String value1 = map.put("黄晓明", "杨颖");
        String value2 = map.put("文章", "马伊琍");
        String value3 = map.put("谢霆锋", "王菲");
        String value22 = map.put("文章", "姚笛");
        String value33 = map.put("李亚鹏", "王菲");

        // 打印Map集合对象
        System.out.println(map);// {文章=姚笛, 谢霆锋=王菲, 李亚鹏=王菲, 黄晓明=杨颖}
        System.out.println("value1:" + value1);// null
        System.out.println("value2:" + value2);// null
        System.out.println("value22:" + value22);// 马伊琍
        System.out.println("value3:" + value3);// null
        System.out.println("value33:" + value33);// null

        //  public  int size() : 计算集合中键值对的个数
        System.out.println("map集合的键值对个数:" + map.size());// map集合的键值对个数:4
    }
}
