package 基础.day11_属性集_缓冲流_转换流_序列化流.demo8_转换输入流InputStreamReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author 彭智林
 * @date 2017/12/30 11:54
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            转换输入流InputStreamReader:
                1.包:java.io
                2.概述: 转换输入流InputStreamReader是一个字符输入流,继承Reader,主要作用是指定编码读取数据
                        可以使用平台默认的字符编码,也可以自己指定字符编码
                3.构造方法:
                    - InputStreamReader(InputStream in) 创建一个转换输入流,使用平台默认的字符编码  idea默认的是utf8
                    - InputStreamReader(InputStream in, String charsetName):创建一个转换输入流,通过参数charsetName指定字符编码
                4.案例1:使用平台默认字符编码读取数据
                4.案例2:通过参数指定字符编码读取数据
         */
        String path = "H:\\gbk.txt";

        // 案例1:使用平台默认字符编码读取数据
        // 1.创建转换输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);// 默认字符编码 utf8

        // 2.定义一个int变量,用来存储读取到的字符数据
        int len;

        // 3.循环读取
        while ((len = isr.read()) != -1) {
            // 4.在循环中,打印读取到的数据
            System.out.println((char) len);// ����� 乱码
        }
        // 5.关闭流,释放资源
        isr.close();

        System.out.println("=====================================================");

        // 案例2:通过参数指定字符编码读取数据
        // 1.创建转换输入流对象,关联数据源文件路径
        FileInputStream fis2 = new FileInputStream(path);
        InputStreamReader isr2 = new InputStreamReader(fis2,"gbk");// 指定字符编码 gbk

        // 2.定义一个int变量,用来存储读取到的字符数据
        int len2;

        // 3.循环读取
        while ((len2 = isr2.read()) != -1) {
            // 4.在循环中,打印读取到的数据
            System.out.println((char) len2);// 中国你好
        }
        // 5.关闭流,释放资源
        isr2.close();


    }
}
