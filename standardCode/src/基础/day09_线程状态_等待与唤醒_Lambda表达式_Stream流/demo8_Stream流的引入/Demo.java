package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo8_Stream流的引入;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭智林
 * @date 2017/12/27 12:24
 */
public class Demo {
    public static void main(String[] args) {
        /*
            例如: 有一个List集合,要求:
                    1.将List集合中姓张的的元素过滤到一个新的集合中
                    2.然后将过滤出来的姓张的元素中过滤出长度为3的元素,存储到一个新的集合中

         */
        // 传统方式操作集合:
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张杰");
        list.add("张三丰");

        // 1.将List集合中姓张的的元素过滤到一个新的集合中
        // 1.1 创建一个新的集合,用来存储所有姓张的元素
        List<String> listB = new ArrayList<>();

        // 1.2 循环遍历list集合,在循环中判断元素是否姓张
        for (String e : list) {
            // 1.3 如果姓张,就添加到新的集合中
            if (e.startsWith("张")) {
                listB.add(e);
            }
        }

        // 2.然后将过滤出来的姓张的元素中过滤出长度为3的元素,存储到一个新的集合中
        // 2.1 创建一个新的集合,用来存储所有姓张的元素并且长度为3
        List<String> listC = new ArrayList<>();

        // 2.2 循环遍历listB集合,在循环中判断元素长度是否为3
        for (String e : listB) {
            // 2.3 如果长度为3,就添加到新的集合中
            if(e.length() == 3){
                listC.add(e);
            }
        }

        // 3.打印所有元素---循环遍历
        for (String e : listC) {
            System.out.println(e);
        }

        System.out.println("====================");
        // 体验Stream流:
        list.stream().filter(e->e.startsWith("张")).filter(e->e.length()==3).forEach(e-> System.out.println(e));
        System.out.println(list);
    }
}
