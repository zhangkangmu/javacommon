package 基础.day10_File类_递归_字节流_字符流.demo10_字节流读取文本文件;

import java.io.FileInputStream;

/**
 * @author 彭智林
 * @date 2017/12/28 16:06
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            字节流读取文本文件存在乱码问题:
                当使用字节流读取文本文件时，可能会有一个小问题。就是遇到中文字符时，可能不会显示完整的字符，
                那是因为一个中文字符可能占用多个字节存储。
                所以Java提供一些字符流类，以字符为单位读写数据，专门用于处理文本文件。
         */
        FileInputStream fis = new FileInputStream("day10\\hhh\\a.txt");
        int len;
        while ((len = fis.read()) != -1){
            char ch = (char)len;
            System.out.println(ch);
        }
        fis.close();
    }
}
