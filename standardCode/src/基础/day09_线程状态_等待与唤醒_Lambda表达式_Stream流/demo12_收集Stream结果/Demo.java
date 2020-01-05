package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo12_收集Stream结果;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 彭智林
 * @date 2017/12/27 16:57
 */
public class Demo {
    public static void main(String[] args) {
        /*
            收集Stream结果:
                收集到集合: List集合,Set集合
                    Stream流中提供了一个方法,可以把流中的数据收集到单列集合中
                    <R,A> R collect(Collector<? super T,A,R> collector): 把流中的数据收集到单列集合中
                                参数Collector<? super T,A,R>: 决定把流中的元素收集到哪个集合中
                                返回值类型是R,也就是说R指定为什么类型,就是收集到什么类型的集合
                                参数Collector如何得到? 使用java.util.stream.Collectors工具类中的静态方法:
                                    - public static <T> Collector<T, ?, List<T>> toList()：转换为List集合。
                                    - public static <T> Collector<T, ?, Set<T>> toSet()：转换为Set集合。


                收集数组: 流中元素对应类型的数组
                    Stream流中提供了一个方法,可以把流中的数据收集到数组中
                    Object[] toArray()  默认收集到Object数组中
                    <A> A[] toArray(IntFunction<A[]> generator)  收集到指定类型的数组  了解
         */
        // stream1流中的数据收集到List集合:
        Stream<String> stream1 = Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").filter(str -> str.startsWith("张"));
        List<String> list = stream1.collect(Collectors.toList());
        System.out.println(list);// 张学友 张家辉

        // stream2流中的数据收集到Set集合:
        Stream<String> stream2 = Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").filter(str -> str.startsWith("张"));
        Set<String> set = stream2.collect(Collectors.toSet());
        System.out.println(set);// [张家辉, 张学友]

        // stream3流中的数据收集到数组中:
        Stream<String> stream3 = Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").filter(str -> str.startsWith("张"));
        Object[] arr = stream3.toArray();
        System.out.println(Arrays.toString(arr));// // 张学友 张家辉

        // String[] arr = stream3.toArray((int length)->{return new String[length];});
        // System.out.println(Arrays.toString(arr));// [张学友, 张家辉]
    }
}
