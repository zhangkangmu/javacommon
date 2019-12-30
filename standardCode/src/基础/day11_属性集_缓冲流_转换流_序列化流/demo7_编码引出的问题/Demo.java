package 基础.day11_属性集_缓冲流_转换流_序列化流.demo7_编码引出的问题;

import java.io.FileReader;

/**
 * @author 彭智林
 * @date 2019/12/30 11:47
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            编码引出的问题:
                字节流读取含有中文的文本文件,会出现乱码
                字符流读取含有中文的文本文件,不会出现乱码,但是要求文本文件中的中文是以utf8编码存储的
                问题: 如果含有中文的文本文件夹是gbk编码的,那么不管你用字节流还是字符流读取都是乱码
                解决问题: 使用转换流,因为转换流可以指定编码读取数据和指定编码写出数据
                         转换输入流
                         转换输出流
         */
        // 需求:使用字符流读取H:\\gbk.txt文件中的数据
        // 1.创建字符输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("H:\\gbk.txt");// 乱码
//        FileReader fr = new FileReader("day11\\utf8.txt");

        // 2.定义一个int变量,用来存储读取到的字符数据
        int len;

        // 3.循环读取
        while ((len = fr.read()) != -1) {
            // 4.在循环中,把读取到的数据打印输出
            System.out.println((char)len);
        }
        // 5.关闭流,释放资源
        fr.close();

    }
}
