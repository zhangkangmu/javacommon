package 基础.day11_属性集_缓冲流_转换流_序列化流.demo10_练习转换文件编码;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author 彭智林
 * @date 2019/12/30 12:11
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            练习: 转换文件编码
                需求:将GBK编码的文本文件，转换为UTF-8编码的文本文件。
                gbk.txt--->java程序--->utf8.txt
                中国你好                中国你好
            思路:
                1. 指定GBK编码的转换流，读取文本文件。
                2. 使用UTF-8编码的转换流，写出文本文件。
         */
        // 1.创建转换输入流对象,关联数据源文件路径,指定编码为gbk
        FileInputStream fis = new FileInputStream("H:\\gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");

        // 2.创建转换输出流对象,关联目的地文件路径,指定编码为utf8
        FileOutputStream fos = new FileOutputStream("day11\\bbb\\utf8.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf8");

        // 3.定义一个int类型的变量,用来存储读取到的字符数据
        int len;

        // 4.循环读取
        while ((len = isr.read()) != -1) {
            // 5.在循环中,写出数据
            osw.write(len);
        }
        // 6.在循环外,关闭流,释放资源
        osw.close();
        isr.close();
    }
}
