package 基础.day10_File类_递归_字节流_字符流.demo9_字节流拷贝文件;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2019/12/28 15:56
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
          字节流拷贝文件:
            1.一次读写一个字节拷贝文件
            1.1 创建字节输入流对象,关联数据源文件路径
            1.2 创建字节输出流对象,关联目的地文件路径
            1.3 定义一个int类型的变量,用来存储读取到的字节数据
            1.4 循环读取数据
            1.5 在循环中,写出数据
            1.6 关闭流,释放资源

            2.一次读写一个字节数组拷贝文件
            2.1 创建字节输入流对象,关联数据源文件路径
            2.2 创建字节输出流对象,关联目的地文件路径
            2.3 定义一个字节数组,用来存储读取到的字节数据
            2.3 定义一个int类型的变量,用来存储读取到的字节个数
            2.4 循环读取数据
            2.5 在循环中,写出数据
            2.6 关闭流,释放资源

            注意:字节流可以拷贝一切类型文件,字符流只能用来拷贝文本文件
         */
        // 2.一次读写一个字节数组拷贝文件
        // 2.1 创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ggg\\hb.jpg");

        // 2.2 创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\ggg\\hbCopy2.jpg");

        // 2.3 定义一个字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        // 2.3 定义一个int类型的变量,用来存储读取到的字节个数
        int len;

        // 2.4 循环读取数据
        while ((len = fis.read(bys)) != -1) {
            // 2.5 在循环中,写出数据
            fos.write(bys,0,len);
        }

        // 2.6 关闭流,释放资源
        fos.close();
        fis.close();
    }

    /**
     * 一次读写一个字节拷贝文件
     *
     * @throws IOException
     */
    private static void method01() throws IOException {
        // 1.一次读写一个字节拷贝文件
        // 1.1 创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ggg\\hb.jpg");

        // 1.2 创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\ggg\\hbCopy1.jpg");

        // 1.3 定义一个int类型的变量,用来存储读取到的字节数据
        int len;

        // 1.4 循环读取数据
        while ((len = fis.read()) != -1) {
            // 1.5 在循环中,写出数据
            fos.write(len);
        }

        // 1.6 关闭流,释放资源
        fos.close();
        fis.close();
    }
}
