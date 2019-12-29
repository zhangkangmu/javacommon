package 基础.day10_File类_递归_字节流_字符流.demo8_字节输入流InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2019/12/28 14:38
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            字节输入流InputStream: 抽象类
                概述:InputStream是一个字节输入流,以字节为基本单位进行读取数据(其他存储设备读取数据到内存)

                由于InputStream是字节输入流顶层父类,所以定义了所有字节输入流共有的方法:
                InputStream类常用方法:
                    - public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
                    - public abstract int read()： 读取一个字节数据,并返回读取到的字节数据,如果读取到文件的末尾,返回-1
                    - public int read(byte[] b)： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。
                                    参数字节数组b:用来存储读取到的字节数据
                                    返回值: 返回的是读取到的字节个数
                                    读取到文件的末尾就返回-1

                    注意:字节输入流使用完毕,需要调用close方法进行关流,释放资源

                由于InputStream是抽象类,无法创建对象,所以得使用它的子类,常用子类: FileInputStream类
                FileInputStream类:是一个字节输入流,以字节为基本单位进行读取数据(其他存储设备读取数据到内存)
                    构造方法:
                        - FileInputStream(String name)： 创建字节输入流对象,传入一个String类型的数据源文件路径。
                        - FileInputStream(File file)： 创建字节输入流对象,传入一个File对象形式的数据源文件路径。

                    注意:如果指定的数据源文件路径不存在,就会报文件找不到异常

                案例1:使用字节输入流一次读取一个字节数据
                案例2:使用字节输入流一次读取一个字节数组长度的字节数据
         */
        // 案例2:使用字节输入流一次读取一个字节数组长度的字节数据
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ggg\\a.txt");
        // 2.读取数据
        byte[] bys = new byte[3];
        /*int len1 = fis.read(bys);
        System.out.println(new String(bys,0,len1));// jac
        System.out.println("len1:"+len1);//  3

        int len2 = fis.read(bys);
        System.out.println(new String(bys,0,len2));// k
        System.out.println("len2:"+len2);// 1

        int len3 = fis.read(bys);
        System.out.println("len3:"+len3);// -1*/

        // 定义一个int类型的变量,用来存储读取到的字节个数
        int len;
        while ( (len = fis.read(bys)) != -1){
            System.out.println(new String(bys,0,len));
        }

        // 3.关闭流,释放资源
        fis.close();
    }

    private static void method03() throws IOException {
        // 案例2:使用字节输入流一次读取一个字节数组长度的字节数据
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ggg\\a.txt");
        // 2.读取数据
        byte[] bys = new byte[2];
        int len1 = fis.read(bys);
        System.out.println(new String(bys,0,len1));// ja
        System.out.println("len1:"+len1);//  2

        int len2 = fis.read(bys);
        System.out.println(new String(bys,0,len2));// ck
        System.out.println("len2:"+len2);// 2

        int len3 = fis.read(bys);
        System.out.println(new String(bys,0,len3));// ck
        System.out.println("len3:"+len3);// -1

        // 3.关闭流,释放资源
        fis.close();
    }

    /**
     * 案例1:使用字节输入流一次读取一个字节数据
     *  public abstract int read()
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 案例1:使用字节输入流一次读取一个字节数据
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day10\\ggg\\a.txt");

        // 2.读取数据
        /*int len1 = fis.read();
        System.out.println((char)len1);//j

        int len2 = fis.read();
        System.out.println((char)len2);//a

        int len3 = fis.read();
        System.out.println((char)len3);//c

        int len4 = fis.read();
        System.out.println((char)len4);//k

        int len5 = fis.read();
        System.out.println(len5);// -1*/

        // 定义一个int类型的变量,用来存储读取到的字节数据
        int len;
        while ((len = fis.read()) != -1){// fis先去文件中读取一个字节数据赋值给len,再拿len和-1进行比较
            System.out.println((char) len);
        }

        // 3.关闭流,释放资源
        fis.close();
    }

    /**
     * FileInputStream类的构造方法
     * @throws FileNotFoundException
     */
    private static void method01() throws FileNotFoundException {
        // 文件路径真实存在:
        // - FileInputStream(String name)： 创建字节输入流对象,传入一个String类型的数据源文件路径。
        FileInputStream fis = new FileInputStream("day10\\ggg\\a.txt");

        // - FileInputStream(File file)： 创建字节输入流对象,传入一个File对象形式的数据源文件路径。
        File file1 = new File("day10\\ggg\\a.txt");
        FileInputStream fis1 = new FileInputStream(file1);


        // 文件路径不存在:
        String path = "day10\\ggg\\b.txt";
//        FileInputStream fis2 = new FileInputStream(path);// 报异常FileNotFoundException
//        FileInputStream fis3 = new FileInputStream(new File(path));// 报异常FileNotFoundException
    }
}
