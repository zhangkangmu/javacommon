package 基础.day05_Collection_List_泛型_数据结构.demo6_使用泛型的好处;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 彭智林
 * @date 2019/12/21 10:12
 */
public class Demo {
    public static void main(String[] args) {
        /*
            泛型概述:在JDK5之后，新增了泛型(Generic)语法，让你在设计API时可以指定类或方法支持泛型，
                    这样我们使用API的时候也变得更为简洁，并得到了编译时期的语法检查。
                    简而言之:泛型就是一种未知的数据类型,在使用的时候确定该泛型的具体数据类型
                    例如:
                        定义类的时候,可以在类名后面加上泛型,表示一种未知的数据类型,然后在使用该类的时候,确定该泛型位置上的具体数据类型
                        定义方法的时候,可以在方法声明上加上泛型,表示一种未知的数据类型,然后在调用该方法的时候,确定该泛型位置上的具体数据类型

                    注意:在使用泛型类或者泛型方法的时候,泛型的位置上只能写引用数据类型
            使用泛型的好处:
                将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
                避免了类型强转的麻烦。
         */
        // 创建一个Collection集合,使用泛型现在集合中的元素类型
        Collection<String> coll = new ArrayList();

        // 往集合中添加元素
        coll.add("林青霞");
        coll.add("亚索");
        coll.add("迪丽热巴");
        /*coll.add(100); 编译失败
        coll.add(3.14);*/

        // 遍历集合
        /*for (Object obj : coll) {
            // 计算所有字符串元素的长度
            String str = (String)obj;// 很容易出现类型转换异常
            System.out.println("str的长度:"+str.length());
        }*/
        for (String str : coll) {
            System.out.println("str的长度:"+str.length());
        }
    }
}
