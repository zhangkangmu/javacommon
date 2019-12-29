package 基础.day05_Collection_List_泛型_数据结构.demo3_Iterator迭代器;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 彭智林
 * @date 2019/12/21 9:32
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Iterator迭代器:
                迭代:即Collection集合元素的通用获取方式。
                    在取元素之前先要判断集合中有没有元素，如果有，就把这个元素取出来，
                    继续在判断，如果还有就再取出来。一直把集合中的所有元素全部取出。这种取出方式专业术语称为迭代。

                获取迭代器:使用Collection集合中的方法iterator()方法
                    public Iterator<E> iterator();获取该集合对象对应的迭代器

                使用迭代器进行判断和取出元素:使用Iterator迭代器的方法
                    boolean hasNext() 判断集合中是否还有元素可以迭代,如果有就返回true,否则返回false。
                    E next() 取出元素。

            迭代器的实现原理:
                在调用Iterator的next方法之前，迭代器的索引位于第一个元素之前，不指向任何元素，
                当第一次调用迭代器的next方法后，迭代器的索引会向后移动一位，指向第一个元素并将该元素返回，
                当再次调用next方法时，迭代器的索引会指向第二个元素并将该元素返回，
                依此类推，直到hasNext方法返回false，表示到达了集合的末尾，终止对元素的遍历。

            注意事项:
                1.如果迭代完了集合中所有元素,就不要再使用迭代器来取元素,否则会出现NoSuchElementException异常
                2.在使用迭代器对集合进行迭代的时候,不要对集合进行增删操作,否则会出现异常
         */
        // 创建一个Collection集合对象,指定集合中元素的类型为String
        Collection<String> coll = new ArrayList<>();

        // 往集合中添加元素: public boolean add(E e)
        coll.add("李冰冰");
        coll.add("范冰冰");
        coll.add("高圆圆");
        coll.add("陈圆圆");

        // 遍历coll集合中的元素:使用Collection集合中的迭代器
        // 获取coll集合对应的迭代器
        Iterator<String> it = coll.iterator();
        // 循环使用迭代器进行判断
        while (it.hasNext()) {
            // 使用迭代器取出元素
            String next = it.next();
            System.out.println("取出来的元素:"+next);
        }

        System.out.println("源集合:"+coll);// 源集合:[李冰冰, 范冰冰, 高圆圆, 陈圆圆]
    }
}
