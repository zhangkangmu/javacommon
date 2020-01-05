package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo11_Stream综合案例;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 彭智林
 * @date 2017/12/27 16:39
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

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        // 1. 第一个队伍只要名字为3个字的成员姓名；
        ArrayList<String> oneList1 = new ArrayList<>();
        for (String e : one) {
            if(e.length() == 3){
                oneList1.add(e);
            }
        }
        // 2. 第一个队伍筛选之后只要前3个人；
        ArrayList<String> oneList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String e = oneList1.get(i);
            oneList2.add(e);
        }

        // 3. 第二个队伍只要姓张的成员姓名；
        ArrayList<String> twoList1 = new ArrayList<>();
        for (String e : two) {
            if(e.startsWith("张")){
                twoList1.add(e);
            }
        }

        // 4. 第二个队伍筛选之后不要前2个人；
        ArrayList<String> twoList2 = new ArrayList<>();
        for (int i = 2; i < twoList1.size(); i++) {
            String e = twoList1.get(i);
            twoList2.add(e);
        }

        // 5. 将两个队伍合并为一个队伍；
        ArrayList<String> list = new ArrayList<>();
        list.addAll(oneList2);
        list.addAll(twoList2);

        // 6. 根据姓名创建Person对象；
        ArrayList<Person> listP = new ArrayList<>();

        for (String name : list) {
            Person p = new Person(name);
            listP.add(p);
        }
        // 7. 打印整个队伍的Person对象信息。
        for (Person person : listP) {
            System.out.println(person);
        }


        System.out.println("================================");
        // Stream流的方式:
        // 1. 第一个队伍只要名字为3个字的成员姓名；
        // 2. 第一个队伍筛选之后只要前3个人；
        Stream<String> stream1 = one.stream().filter((String str) -> {
            return str.length() == 3;
        }).limit(3);

        // 3. 第二个队伍只要姓张的成员姓名；
        // 4. 第二个队伍筛选之后不要前2个人；
        Stream<String> stream2 = two.stream().filter((String str) -> {
            return str.startsWith("张");
        }).skip(2);

        // 5. 将两个队伍合并为一个队伍；
        // 6. 根据姓名创建Person对象；
        // 7. 打印整个队伍的Person对象信息。
        Stream.concat(stream1,stream2).map((String name)->{return new Person(name);}).forEach((Person p)->{
            System.out.println(p);
        });

    }
}
