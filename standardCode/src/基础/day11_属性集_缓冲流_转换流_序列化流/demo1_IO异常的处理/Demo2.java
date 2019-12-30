package 基础.day11_属性集_缓冲流_转换流_序列化流.demo1_IO异常的处理;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2019/12/30 8:48
 */
public class Demo2 {
    public static void main(String[] args) {
        /**
         jdk1.7以后IO异常的处理: try-with-resource 语句，该语句确保了每个资源在语句结束时关闭。
         所谓的资源（resource）是指在程序完成后，必须关闭的对象。
         简而言之:自动关闭流,自动释放资源
         格式:
         try(创建流对象的语句，如果多个,使用';'隔开){
         读写数据
         }catch(异常类型 变量名){

         }
         */
        try (
                // 1.创建字节输入流对象,关联数据源文件路径
                FileInputStream fis = new FileInputStream("day11\\aaa\\hb.jpg");
                // 2.创建字节输出流对象,关联目的地文件路径
                FileOutputStream fos = new FileOutputStream("day11\\aaa\\hbCopy2.jpg");
        ) {
            // 3.定义一个字节数组,用来存储读取到的字节数据
            byte[] bys = new byte[8192];

            // 3.定义一个int类型的变量,用来存储读取到的字节个数
            int len;

            // 4.循环读取数据
            while ((len = fis.read(bys)) != -1) {
                // 5.在循环中,写出数据
                fos.write(bys, 0, len);
            }
        } catch (IOException e) {

        }finally {

        }
    }
}
