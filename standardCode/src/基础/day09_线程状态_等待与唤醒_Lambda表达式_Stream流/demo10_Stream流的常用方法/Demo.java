package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo10_Stream流的常用方法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author 彭智林
 * @date 2017/12/27 15:21
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Stream流的特点:
                1.首先应该搭建完整的函数模型,函数模型中一定要包含终结方法
                     终结方法: Stream流中的方法的返回值类型不是Stream类型
                     延迟方法:Stream流中的方法的返回值类型是Stream类型
                2.Stream流不能存储数据
                3.Stream流不能重复使用
                4.Stream流不会修改数据源

            Stream常用方法:
                终结方法:
                    void forEach(Consumer<? super T> action)  对此流的每个元素执行操作。 该方法并不保证元素的逐一消费动作在流中是被有序执行的。
                                参数Consumer<T>:是一个接口,并且是一个函数式接口,所以参数可以传入该接口对应的Lambda表达式
                                Consumer<T>接口中的抽象方法:  void accept(T t);

                    long count() 返回此流中的元素个数。

                延迟方法:
                    Stream<T> filter(Predicate<? super T> predicate): 过滤功能的方法,把符合条件的元素组成一个新的流返回
                                参数Predicate<T>:是一个接口,并且是一个函数式接口,所以参数可以传入该接口对应的Lambda表达式
                                Predicate<T>接口的抽象方法: boolean test(T t)

                    Stream<T> limit(long maxSize) : 保留流中的前几个元素,组成一个新的流返回
                    Stream<T> skip(long n) : 跳过前几个元素,剩余的元素组成一个新的流返回
                    <R> Stream<R> map(Function<? super T,? extends R>  mapper) : 映射 把流中元素的T类型转换为R类型,组成一个新的流并返回
                                                                                T和R的类型可以一致,也可以不一致
                                      参数Function<T,R>:是一个接口,并且是一个函数式接口,所以参数可以传入该接口对应的Lambda表达式
                                      Function<T,R>接口的抽象方法: R apply(T t);

                    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b): a和b流合并,组成一个新的流返回
            Stream流的使用步骤: 获取流--->操作流--->处理结果
         */
    }

    /**
     * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
     */
    private static void method07() {
        Stream<String> stream1 = Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉");

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"10","20","30","40","50");
        Stream<String> stream2 = list.stream();

        // 需求:合并stream1和stream2
        Stream.concat(stream1,stream2).forEach(str-> System.out.println(str));
    }

    /**
     * <R> Stream<R> map(Function<? super T,? extends R>  mapper)
     */
    private static void method06() {
        // 流中的String类型元素 转换成 String类型
        Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").map((String str)->{return str+"天王";}).forEach(str-> System.out.println(str));

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"10","20","30","40","50");
        // 需求: 把list集合中的所有元素变成Integer类型,并+10,打印输出
        list.stream().map((String str)->{return Integer.parseInt(str);}).forEach(str-> System.out.println(str+10));
    }

    /**
     *  Stream<T> skip(long n)
     */
    private static void method05() {
        Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").skip(3).forEach(str-> System.out.println(str));
    }

    /**
     *  Stream<T> limit(long maxSize)
     */
    private static void method04() {
        Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").limit(3).forEach(str-> System.out.println(str));
    }

    /**
     * Stream<T> filter(Predicate<? super T> predicate)
     */
    private static void method03() {
    /* // 获取流:
     Stream<String> stream1 = Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉");
     // 过滤出姓张的元素:
     Stream<String> stream2 = stream1.filter((String str) -> {
         // 过滤条件
         if (str.startsWith("张")) {
             return true;
         } else {
             return false;
         }
         // return str.startsWith("张");
     });
     stream2.forEach(str ->System.out.println(str));*/

        Stream.of("刘德华", "张学友", "黎明", "郭富城", "张家辉").filter(str->str.startsWith("张")).forEach(str ->System.out.println(str));
    }

    /**
     * long count() 返回此流中的元素个数。
     */
    private static void method2() {
        // 获取流:
        Stream<String> stream1 = Stream.of("刘德华", "张学友", "黎明", "郭富城");
        // 调用count()方法;
        long count = stream1.count();
        System.out.println("stream1流中元素的个数:" + count);// stream1流中元素的个数:4
    }

    /**
     * void forEach(Consumer<? super T> action)
     */
    private static void method1() {
        // 非并发流:
        // 获取流:
        Stream<String> stream1 = Stream.of("刘德华", "张学友", "黎明", "郭富城");
        // forEach操作:
        stream1.forEach((String str) -> {
            System.out.println(str);
        });

        System.out.println("=========================================");
        // 并发流:
        Stream<String> stream2 = Stream.of("刘德华", "张学友", "黎明", "郭富城");// 非并发流
        Stream<String> stream3 = stream2.parallel();// 并发流
        stream3.forEach(str -> System.out.println(str));
    }
}
