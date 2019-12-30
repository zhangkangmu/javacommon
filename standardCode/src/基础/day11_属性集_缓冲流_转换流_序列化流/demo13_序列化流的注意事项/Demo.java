package 基础.day11_属性集_缓冲流_转换流_序列化流.demo13_序列化流的注意事项;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 彭智林
 * @date 2019/12/30 14:46
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            序列化流的注意事项:
                1.要序列化的对象所属的类一定要实现序列化接口Serializable
                2.该类的所有属性必须是可序列化的
                3.如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用 transient 关键字修饰。
         */
        // 序列化
     /*   // 1.创建一个Person对象
        Person p = new Person("张三",18,new Animal());

        // 2.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\person1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 3.写出Person对象
        oos.writeObject(p);

        // 4.关闭流,释放资源
        oos.close();*/

       // 反序列化:
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\person1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.读取一个对象
        Object obj = ois.readObject();
        System.out.println(obj);

        // 3.关闭流,释放资源
        ois.close();
    }
}
