package 基础.day11_属性集_缓冲流_转换流_序列化流.demo12_反序列化流ObjectInputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author 彭智林
 * @date 2019/12/30 14:40
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /**
            反序列化流ObjectInputStream:
                1.包: java.io
                2.概述:ObjectInputStream表示反序列化流(字节输入流) 继承InputStream
                3.作用:将之前使用ObjectOutputStream序列化的原始数据恢复为对象。 (将文件中的对象数据重构成对象)
                4.构造方法:
                         public ObjectInputStream(InputStream in)： 创建一个指定InputStream的ObjectInputStream。
                5.特有方法:
                        public final Object readObject () : 读取一个对象。
         */
        // 1.创建反序列化流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\ccc\\person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 2.读取一个对象
        Object obj = ois.readObject();
        System.out.println(obj);

        // 3.关闭流,释放资源
        ois.close();
    }
}
