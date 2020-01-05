package 基础.day05_Collection_List_泛型_数据结构.demo14_List的子类;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author 彭智林
 * @date 2017/12/21 15:53
 */
public class Demo {
    public static void main(String[] args) {
        /*
             List的子类:
                ArrayList类:也称ArrayList集合,存储数据的数据结构是数组,特点:查询快,增删慢,线程不安全
                LinkedList类:也称LinkedList集合,存储数据的数据结构是链表,特点:查询慢,增删快
                LinkedList集合特有的方法:LinkedList提供了大量首尾操作的方法
                    - public void addFirst(E e):将指定元素插入此列表的开头。
                    - public void addLast(E e):将指定元素添加到此列表的结尾。
                    - public E getFirst():返回此列表的第一个元素。
                    - public E getLast():返回此列表的最后一个元素。
                    - public E removeFirst():移除并返回此列表的第一个元素。
                    - public E removeLast():移除并返回此列表的最后一个元素。
                    - public E pop():从此列表所表示的堆栈处弹出一个元素。
                    - public void push(E e):将元素推入此列表所表示的堆栈。
                    - public boolean isEmpty()：如果列表不包含元素，则返回true。忽略,不是特有的
         */
        // 创建一个LinkedList集合,限制集合中元素的类型为String类型
        LinkedList<String> list = new LinkedList<>();

        // 往集合中添加一些元素
        list.add("王宝强");
        list.add("贾乃亮");
        list.add("文章");
        list.add("陈羽凡");
        System.out.println(list);// [王宝强, 贾乃亮, 文章, 陈羽凡]

        // 添加一个元素在集合的开头位置: public void addFirst(E e)
        list.addFirst("谢霆锋");

        // 添加一个元素在集合的末尾位置: public void addLast(E e)
        list.addLast("吴秀波");
        System.out.println(list);// [谢霆锋, 王宝强, 贾乃亮, 文章, 陈羽凡, 吴秀波]

        // 获取集合中的第一个元素:public E getFirst()
        System.out.println("集合中第一个元素为:"+list.getFirst());// 集合中第一个元素为:谢霆锋

        // 获取集合中的最后一个元素:public E getLast()
        System.out.println("集合中最后一个元素为:"+list.getLast());// 集合中最后一个元素为:吴秀波

        // 删除集合中的第一个元素:public E removeFirst()
        String removeFirst = list.removeFirst();
        System.out.println("被删除的元素:"+removeFirst);// 谢霆锋
        System.out.println("删除第一个元素后的集合:"+list);// [王宝强, 贾乃亮, 文章, 陈羽凡, 吴秀波]

        // 删除集合中的最后一个元素:public E removeLast()
        String removeLast = list.removeLast();
        System.out.println("被删除的元素:"+removeLast);// 吴秀波
        System.out.println("删除最后一个元素后的集合:"+list);// [王宝强, 贾乃亮, 文章, 陈羽凡]

        // public E pop():从此列表所表示的堆栈处弹出一个元素。 删除第一个元素
        String popE = list.pop();
        System.out.println("popE:"+popE);// popE:王宝强
        System.out.println("调用pop方法后的集合:"+list);// [贾乃亮, 文章, 陈羽凡]

        // public void push(E e):将元素推入此列表所表示的堆栈。添加一个元素在集合的开头位置
        list.push("刘强东");
        System.out.println("调用push方法后的集合:"+list);// [刘强东, 贾乃亮, 文章, 陈羽凡]

      int[] arr=new int[10];
        System.out.println(arr[9]);
    }
}
