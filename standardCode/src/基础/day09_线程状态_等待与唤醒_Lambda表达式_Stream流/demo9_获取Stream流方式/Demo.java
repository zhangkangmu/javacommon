package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo9_获取Stream流方式;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 彭智林
 * @date 2017/12/27 15:05
 */
public class Demo {
    public static void main(String[] args) {
        /*
            获取Stream流方式:
                 Collection接口中有一个stream()方法,可以获取流
                       default Stream<E> stream():获取一个Stream流
                         1.通过List集合获取:
                         2.通过Set集合获取

                3.通过Map集合获取:
                    3.1 使用所有键的集合来获取流
                    3.2 使用所有值的集合来获取流
                    3.3 使用所有键值对的集合来获取流

                Stream流中有一个static <T> Stream<T> of(T... values)
                     4.通过数组获取:
                     5.通过直接给多个数据的方式
         */
        // 1.通过List集合获取:
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"苍老师","波老师","小泽老师","龙老师");
        Stream<String> stream1 = list.stream();// 非并发流
        Stream<String> stringStream = list.parallelStream();// 直接得到并发流

        // 2.通过Set集合获取:
        Set<String> set = new HashSet<>();
        Collections.addAll(set,"王老师","张老师","曾老师","陈老师");
        Stream<String> stream2 = set.stream();


        // 3.通过Map集合获取:
        Map<String,String> map = new HashMap<>();
        map.put("谢霆锋","张柏芝");
        map.put("王宝强","马蓉");
        map.put("贾乃亮","李小璐");
        map.put("陈羽凡","白百何");

        // 3.1 使用所有键的集合来获取流
        Set<String> keys = map.keySet();
        Stream<String> stream3 = keys.stream();

        // 3.2 使用所有值的集合来获取流
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        // 3.3 使用所有键值对的集合来获取流
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entrySet.stream();


        // 4.通过数组获取:
        String[] arr = {"老王","老李","老郭","老张"};
        Stream<String> stream6 = Stream.of(arr);

        // 5.通过直接给多个数据的方式
        Stream<String> stream7 = Stream.of("黄晓明", "邓超", "陈赫", "古天乐");


    }
}
