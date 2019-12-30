package 基础.day11_属性集_缓冲流_转换流_序列化流.demo4_字节缓冲流;

import java.io.*;

/**
 * @author 彭智林
 * @date 2019/12/30 10:00
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            字节缓冲流：BufferedInputStream，BufferedOutputStream
            特点:
                1.字节缓冲流是字节流的子类
                2.读写效率高,没有特有功能方法
            构造方法:
                - public BufferedInputStream(InputStream in) ：创建一个 新的缓冲输入流。
                - public BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流。

            测试缓冲流读写效率:其实就是计算拷贝一个文件所花的时间
                 测试一:使用字节缓冲流一次读写一个字节拷贝文件
                     1.创建字节缓冲输入流对象,关联数据源文件路
                     2.创建字节缓冲输出流对象,关联目的地文件路
                     3.定义一个int类型的变量,用来存储读取到的字节数据
                     4.循环读取数据
                     5.在循环中,写出数据
                     6.关闭流,释放资源

                 测试二:使用字节缓冲流一次读写一个字节数组拷贝文件
                     1.创建字节缓冲输入流对象,关联数据源文件路
                     2.创建字节缓冲输出流对象,关联目的地文件路
                     3.定义一个字节数组,用来存储读取到的字节数据
                     3.定义一个int类型的变量,用来存储读取到的字节个数
                     4.循环读取数据
                     5.在循环中,写出数据
                     6.关闭流,释放资源
         */
        String path = "H:\\jdk9.exe";// 字节大小:393,799,736 字节  375MB

        // 测试一:使用普通字节流一次读写一个字节拷贝文件
        // 0.获取当前系统的时间
        long start = System.currentTimeMillis();

        // 1.创建普通字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream(path);

        // 2.创建普通字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\aaa\\jdk9Copy3.exe");

        // 3.定义一个int类型的变量,用来存储读取到的字节数据
        int len;

        // 4.循环读取数据
        while ((len = fis.read()) != -1) {
            // 5.在循环中,写出数据
            fos.write(len);
        }

        // 6.关闭流,释放资源
        fos.close();
        fis.close();

        // 7.获取当前系统的时间
        long end = System.currentTimeMillis();
        System.out.println("总共花的时间是:"+(end-start));// 至少需要十几分钟

    }

    /**
     *  测试二:使用字节缓冲流一次读写一个字节数组拷贝文件
     * @throws IOException
     */
    private static void method02() throws IOException {
        String path = "H:\\jdk9.exe";// 字节大小:393,799,736 字节  375MB

        //  测试二:使用字节缓冲流一次读写一个字节数组拷贝文件
        // 0.获取当前系统的时间
        long start = System.currentTimeMillis();

        // 1.创建字节缓冲输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 2.创建字节缓冲输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\aaa\\jdk9Copy2.exe");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 3.定义一个字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        // 3.定义一个int类型的变量,用来存储读取到的字节个数
        int len;

        // 4.循环读取数据
        while ((len = bis.read(bys)) != -1) {
            // 5.在循环中,写出数据
            bos.write(bys,0,len);
        }

        // 6.关闭流,释放资源
        bos.close();
        bis.close();

        // 7.获取当前系统的时间
        long end = System.currentTimeMillis();
        System.out.println("总共花的时间是:"+(end-start));// 总共花的时间是:1512 约等于1.5秒
    }

    /**
     *  测试一:使用字节缓冲流一次读写一个字节拷贝文件
     * @throws IOException
     */
    private static void method01() throws IOException {
        String path = "H:\\jdk9.exe";// 字节大小:393,799,736 字节  375MB

        // 测试一:使用字节缓冲流一次读写一个字节拷贝文件
        // 0.获取当前系统的时间
        long start = System.currentTimeMillis();

        // 1.创建字节缓冲输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 2.创建字节缓冲输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\aaa\\jdk9Copy1.exe");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 3.定义一个int类型的变量,用来存储读取到的字节数据
        int len;

        // 4.循环读取数据
        while ((len = bis.read()) != -1) {
            // 5.在循环中,写出数据
            bos.write(len);
        }

        // 6.关闭流,释放资源
        bos.close();
        bis.close();

        // 7.获取当前系统的时间
        long end = System.currentTimeMillis();
        System.out.println("总共花的时间是:"+(end-start));// 总共花的时间是:24789  约等于25秒
    }
}
