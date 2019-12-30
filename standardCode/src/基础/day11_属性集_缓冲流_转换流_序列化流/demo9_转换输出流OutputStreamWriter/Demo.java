package 基础.day11_属性集_缓冲流_转换流_序列化流.demo9_转换输出流OutputStreamWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author 彭智林
 * @date 2019/12/30 12:04
 */
public class Demo {
    public static void main(String[] args)throws Exception {
        /*
            转换输出流OutputStreamWriter:
                1.包:java.io
                2.概述: 转换输出流OutputStreamWriter是一个字符输输出流,继承Writer,主要作用是指定编码写出数据
                        可以使用平台默认的字符编码,也可以自己指定字符编码
                3.构造方法:
                    - OutputStreamWriter(OutputStream in) 创建一个转换输输出流,使用平台默认的字符编码  idea默认的是utf8
                    - OutputStreamWriter(OutputStream in, String charsetName):创建一个转换输输出流,通过参数charsetName指定字符编码
                4.案例1:使用平台默认字符编码写出数据
                4.案例2:通过参数指定字符编码写出数据
         */
        // 案例1:使用平台默认字符编码写出数据
        /*// 1.创建转换输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\bbb\\b.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);// 默认是utf8编码,utf8编码中一个中文占3个字节

        // 2.写出数据
        osw.write("中国你好");// 12个字节

        // 3.关闭流,释放资源
        osw.close();*/

        // 案例2:通过参数指定字符编码写出数据
        // 1.创建转换输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\bbb\\c.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");//指定gbk编码,gbk编码中一个中文占2个字节

        // 2.写出数据
        osw.write("中国你好");// 8个字节

        // 3.关闭流,释放资源
        osw.close();
    }
}
