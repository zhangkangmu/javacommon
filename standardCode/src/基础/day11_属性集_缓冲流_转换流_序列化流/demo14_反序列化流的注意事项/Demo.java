package 基础.day11_属性集_缓冲流_转换流_序列化流.demo14_反序列化流的注意事项;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 彭智林
 * @date 2019/12/30 14:55
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            反序列化流的注意事项:
                1.如果能找到一个对象的class文件，我们可以进行反序列化操作;
                   如果找不到该类的class文件，则抛出一个 ClassNotFoundException 异常。
                2.另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，
                  那么反序列化操作也会失败，抛出一个InvalidClassException异常
         */
       /* // 1.创建一个Person对象
        Person p = new Person("张三",18);

        // 2.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\person2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 3.写出Person对象
        oos.writeObject(p);

        // 4.关闭流,释放资源
        oos.close();*/

        // 反序列化:
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\person2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.读取一个对象
        Object obj = ois.readObject();
        System.out.println(obj);

        // 3.关闭流,释放资源
        ois.close();
    }
}
