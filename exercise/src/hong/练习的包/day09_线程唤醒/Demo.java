package hong.练习的包.day09_线程唤醒;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class Demo {

    public static void main(String[] args) {
         /*
            现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下若干操作步骤：
                1. 第一个队伍只要名字为3个字的成员姓名；
                2. 第一个队伍筛选之后只要前3个人；
                3. 第二个队伍只要姓张的成员姓名；
                4. 第二个队伍筛选之后不要前2个人；
                5. 将两个队伍合并为一个队伍；
                6. 根据姓名创建Person对象；
                7. 打印整个队伍的Person对象信息。
         */
        // 传统方式:
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        Stream<String> limit = one.stream().filter(str -> str.length() == 3).limit(3);


        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
        Stream<String> steam2 = two.stream().filter(s -> s.startsWith("张")).skip(2);
        Stream<String> concat = Stream.concat(limit, steam2);

        //6. 根据姓名创建Person对象；
        //7. 打印整个队伍的Person对象信息。
        ArrayList<PersonTest> people = new ArrayList<>();
        List<String> collect = concat.collect(Collectors.toList());
        for (String s : collect) {
            people.add(new PersonTest(s));
        }
        for (PersonTest person : people) {
            System.out.println(person);
        }

    }
}
