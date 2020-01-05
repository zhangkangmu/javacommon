package 基础.day11_属性集_缓冲流_转换流_序列化流.demo15_练习序列化集合;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @author 彭智林
 * @date 2017/12/30 15:05
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            练习序列化集合:
            需求:
                1. 将存有多个自定义对象的集合序列化操作，保存到list.txt文件中。
                2. 反序列化list.txt ，并遍历集合，打印对象信息。
            分析:
                1.创建一个自定义的Person类,并创建该类的多个对象
                2.创建list集合,把Person类的对象添加到集合中
                3.创建序列化流对象,关联目的地文件路径
                4.写出list集合对象
                5.关闭流,释放资源

                1.创建反序列化流对象,关联数据源文件路径
                2.读取一个集合对象
                3.遍历集合，打印对象信息。
                4.关闭流,释放资源
         */
     /*  //  1.创建一个自定义的Person类,并创建该类的多个对象
        Person p1 = new Person("张三",18);
        Person p2 = new Person("李四",28);
        Person p3 = new Person("王五",38);
        Person p4 = new Person("赵六",48);

       //  2.创建list集合,把Person类的对象添加到集合中
        ArrayList<Person> list = new ArrayList<>();
        Collections.addAll(list,p1,p2,p3,p4);

       //  3.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\list.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

       //  4.写出list集合对象
        oos.writeObject(list);

       //  5.关闭流,释放资源
        oos.close();*/

        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\list.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.读取一个集合对象
        ArrayList<Person> list = (ArrayList<Person>)ois.readObject();

        // 3.遍历集合，打印对象信息。
        for (Person p : list) {
            System.out.println(p);
        }
        // 4.关闭流,释放资源
        ois.close();
    }
}
