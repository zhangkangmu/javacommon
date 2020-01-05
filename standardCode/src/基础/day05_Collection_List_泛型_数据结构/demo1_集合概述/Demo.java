package 基础.day05_Collection_List_泛型_数据结构.demo1_集合概述;

/**
 * @author 彭智林
 * @date 2017/12/21 8:39
 */
public class Demo {
    public static void main(String[] args) {
        /*
            集合的概述:
                集合:集合是java中提供的一种容器，可以用来存储多个引用数据类型的数据。
                特点:
                    1.集合的长度是不固定的
                    2.集合中的元素类型只能是引用数据类型
                    3.集合中的元素类型可以一致,也可以不一致,但是建议是要一致

                数组:数组是java中提供的一种容器,可以用来存储固定个数相同类型的数据
                特点:
                    1.数组的长度是固定的
                    2.数组中的元素类型可以是基本数据类型,也可以是引用数据类型 例如:int[]  String[]
                    3.数组中的元素类型一定要一致

            集合的继承体系:
                单列集合:以单个单个的方式存储元素
                    Collection接口:也称Collection集合,定义了所有单列集合共有的功能
                        List接口:也称List集合,特点:元素有索引,元素存取有序,元素可以重复
                            Vector类:也称Vector集合,特点:查询快,增删慢,线程安全
                            ArrayList类:也称ArrayList集合,特点:查询快,增删慢,线程不安全
                            LinkedList类:也称LinkedList集合,特点:查询慢,增删快

                        Set接口:也称Set集合,特点:元素无索引,元素存取无序,元素不可以重复
                            HashSet类:也称HashSet集合,特点:元素无索引,元素存取无序,元素不可以重复
                                LinkedHashSet类:也称LinkedHashSet集合,特点:元素无索引,元素存取有序,元素不可以重复
                            TreeSet类:也称TreeSet集合,特点:元素无索引,元素存取无序,元素不可以重复,可以对元素进行排序

                双列集合:以键值对的方式存储元素(键值对)
                    Map接口:也称Map集合
                         HashMap类:也称HashMap集合
                                LinkedHashMap类:也称LinkedHashMap集合
                         TreeMap类:也称TreeMap集合
         */
    }
}
