package 基础.day11_属性集_缓冲流_转换流_序列化流.demo1_IO异常的处理;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2017/12/30 8:48
 */
public class Demo {
    public static void main(String[] args) {
        /**
         jdk1.7以前IO异常的处理: try...catch...finally
         */
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1.创建字节输入流对象,关联数据源文件路径
            fis = new FileInputStream("day11\\aaa\\hb.jpg");

            // 2.创建字节输出流对象,关联目的地文件路径
            fos = new FileOutputStream("day11\\aaa\\hbCopy1.jpg");

            // 3.定义一个字节数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];

            // 3.定义一个int类型的变量,用来存储读取到的字节个数
            int len;

            // 4.循环读取数据
            while ((len = fis.read(bys)) != -1) {
                // 5.在循环中,写出数据
                fos.write(bys, 0, len);
            }


        } catch (Exception e) {
            // 异常信息
        } finally {
            // 一般正常情况,永远都会执行,一般用来释放资源
            // 6.关闭流,释放资源
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                // 异常信息
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    // 异常信息
                }
            }
        }
    }
}
