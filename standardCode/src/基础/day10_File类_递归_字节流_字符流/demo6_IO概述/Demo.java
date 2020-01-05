package 基础.day10_File类_递归_字节流_字符流.demo6_IO概述;

/**
 * @author 彭智林
 * @date 2017/12/28 11:15
 */
public class Demo {
    public static void main(String[] args) {
        /*
            IO概述:
                I: Input  输入   从其他存储设备读取数据到内存中    硬件--->内存
                O: Output 输出   从内存中写出数据到其他存储设备    内存--->硬件

                IO流的分类
                    按照流向分:
                        输入流:读取数据 从其他存储设备读取数据到内存中的流
                            字节输入流
                            字符输入流

                        输出流:写出数据 从内存中写出数据到其他存储设备的流
                            字节输出流
                            字符输出流
                   按照类型分:
                        字节流:以字节为基本单位,进行读写操作
                            字节输入流
                            字节输出流
                        字符流:以字符为基本单位,进行读写操作
                            字符输入流
                            字符输出流

               IO流的父类:
                     字节输入流:顶层父类是 InputStream   抽象类
                     字节输出流:顶层父类是 OutputStream  抽象类
                     字符输入流:顶层父类是 Reader        抽象类
                     字符输出流:顶层父类是 Writer        抽象类


              注意:
                1.IO流中的类一般都在java.io包
                2.集合中的类一般都在java.util包
                3.idea默认编码为utf8编码,windows系统默认编码为gbk编码
                4.如果存数据使用的编码和解析数据使用的编码不一致,就会乱码
                5.utf8编码下一个中文占3个字节,gbk编码下一个中文占2个字节

         */
        String str = "itheima";
    }
}
