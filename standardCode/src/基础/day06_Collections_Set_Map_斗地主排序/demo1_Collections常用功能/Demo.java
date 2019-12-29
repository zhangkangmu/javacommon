package 基础.day06_Collections_Set_Map_斗地主排序.demo1_Collections常用功能;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 彭智林
 * @date 2019/12/22 8:56
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Collections常用功能:
                - public static void shuffle(List<?> list):打乱集合中元素的顺序。
                - public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
                    默认规则: 事先写好的规则
                    对集合中的元素按照默认规则排序,要求该集合元素所属的类实现Comparable接口,重写compareTo()方法
                    然后在compareTo()方法中指定排序的默认规则

                - public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。
                    指定规则: 自己定义的规则
                    参数Comparator<T>接口:也称比较器接口,用来指定排序的规则
         */
        // 创建一个List集合对象,限制集合中元素类型为Integer
        List<Integer> list = new ArrayList<>();
        // 往集合中添加一些元素
        list.add(300);
        list.add(100);
        list.add(200);
        list.add(500);
        list.add(400);
        System.out.println("排序之前的集合:"+list);// 打乱顺序之前:[300, 100, 200, 500, 400]

        // 对list集合指定规则排序: 降序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定排序规则
                // 前减后:升序
                // 后减前:降序
                // 前:第一个参数  o1
                // 后:第二个参数  o2
                return o2 - o1;
            }
        });

        System.out.println("排序之后的集合:"+list);// 排序之后的集合:[500, 400, 300, 200, 100]

        // 对list集合指定规则排序: 升序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定排序规则
                // 前减后:升序
                // 后减前:降序
                // 前:第一个参数  o1
                // 后:第二个参数  o2
                return o1 - o2;
            }
        });
        System.out.println("排序之后的集合:"+list);// 排序之后的集合:[100, 200, 300, 400, 500]

    }

    /**
     * public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
     * 集合中的元素为自定义类型的对象
     */
    private static void method03() {
        // 需求:定义一个集合,用来存储Person类型的对象,并按照默认规则对该集合中的元素进行排序
        // 创建多个Person对象
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("李四", 38);
        Person p3 = new Person("王五", 28);
        // 创建一个List集合对象,限制集合中元素类型为Person
        List<Person> list = new ArrayList<>();
        // 往该集合中添加Person对象
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println("排序之前的集合:"+list);

        // 将集合中元素按照默认规则排序
        Collections.sort(list);
        System.out.println("排序之后的集合:"+list);
    }

    /**
     *  public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
     *  集合中的元素为系统类的对象
     */
    private static void method02() {
        // 创建一个List集合对象,限制集合中元素类型为Integer
        List<Integer> list = new ArrayList<>();
        // 往集合中添加一些元素
        list.add(300);
        list.add(100);
        list.add(200);
        list.add(500);
        list.add(400);
        System.out.println("排序之前的集合:"+list);// 打乱顺序之前:[300, 100, 200, 500, 400]

        // 将集合中元素按照默认规则排序: public static <T> void sort(List<T> list)
        Collections.sort(list);
        System.out.println("排序之后的集合:"+list);// 排序之后的集合:[100, 200, 300, 400, 500]
    }

    /**
     * public static void shuffle(List<?> list):打乱集合中元素的顺序。
     */
    private static void method01() {
        // 创建一个List集合对象,限制集合中元素类型为Integer
        List<Integer> list = new ArrayList<>();
        // 往集合中添加一些元素
        list.add(300);
        list.add(100);
        list.add(200);
        list.add(500);
        list.add(400);
        System.out.println("打乱顺序之前:"+list);// 打乱顺序之前:[300, 100, 200, 500, 400]

        // 随机打乱集合中元素的顺序:public static void shuffle(List<?> list)
        Collections.shuffle(list);
        System.out.println("打乱顺序之后:"+list);
    }
}
