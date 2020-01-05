package 基础.day11_属性集_缓冲流_转换流_序列化流.demo11_序列化流ObjectOutputStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author 彭智林
 * @date 2017/12/30 12:23
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
                序列化:
                序列化中的输出流, 也叫做序列化流.序列化中的输入流,叫做反序列化流

            序列化流ObjectOutputStream:
                1.包: java.io
                2.概述:ObjectOutputStream是一个序列化流(字节输出流),继承OutputStream
                3.作用:将Java对象的原始数据类型写出到文件,实现对象的持久存储。(把对象写出到文件中)
                4.构造方法:
                    public ObjectOutputStream(OutputStream out)： 创建一个指定OutputStream的ObjectOutputStream。
                5.特有的方法: 写出一个java对象
                    public final void writeObject (Object obj) : 将指定的对象写出。
                6.注意事项:
                    6.1 要序列化的对象所属的类一定要实现序列化接口Serializable

         */
        // 1.创建一个Person对象
        Person p = new Person("张三",18);

        // 2.创建序列化流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ccc\\person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 3.写出Person对象
        oos.writeObject(p);

        // 4.关闭流,释放资源
        oos.close();
    }
}
