package 基础.day10_File类_递归_字节流_字符流.demo7_字节输出流OutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2017/12/28 11:54
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            字节输出流:顶层父类是 OutputStream  抽象类
                概述:OutputStream是一个字节输出流,用来将字节数据写出到目的地文件,该类中定义了所有字节输出流共有的方法
                OutputStream抽象类的常用方法:
                    - public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
                    - public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。

                    - public abstract void write(int b) ：一次写出一个字节数据  参数:字节数据
                    - public void write(byte[] b)：将b数组中的所有字节数据写出到目的地文件中
                    - public void write(byte[] b, int off, int len) ：将b数组中的字节数据,从off索引开始写出,总共写len个字节数据

                    注意:输出流使用完毕,记得调用close()方法关闭流

                OutputStream常用子类: FileOutputStream类
                    概述:FileOutputStream类继承OutputStream类,所以FileOutputStream是一个字节输出流,用来将字节数据写出到目的地文件

                FileOutputStream类的构造方法:
                    - public FileOutputStream(String name)： 创建文件输出流以指定的名称写入文件。
                    - public FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件。
                    - public FileOutputStream(String name, boolean append) ：创建文件,并且以追加的形式。
                    注意:
                        当你创建一个流对象时，必须传入一个文件路径:
                            1.该路径下，如果没有这个文件，会创建该文件。
                            2.如果有这个文件，会清空这个文件的数据。

               数据追加续写:
                    - public FileOutputStream(String name, boolean append)： 创建文件输出流以指定的名称写入文件。
                    - public FileOutputStream(File file, boolean append)： 创建文件输出流以写入由指定的 File对象表示的文件。

                    注意: boolean类型的参数传入的是true,那么写出数据的时候就是拼接,否则就是覆盖
         */
        // 字节输出流写出换行:
        /*
            需求:把一首诗写入到day10\\fff\\d.txt中
            静夜思
            床前明月光
            疑是地上霜
            举头望明月
            低头思故乡
         */
        // 1.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\fff\\d.txt");

        // 2.写出数据  String类: byte[] getBytes() 把字符串转换为字节数组
        fos.write("  静夜思".getBytes());
        fos.write("\r\n".getBytes());

        fos.write("床前明月光".getBytes());
        fos.write("\r\n".getBytes());

        fos.write("疑是地上霜".getBytes());
        fos.write("\r\n".getBytes());

        fos.write("举头望明月".getBytes());
        fos.write("\r\n".getBytes());

        fos.write("低头思故乡".getBytes());
        fos.write("\r\n".getBytes());

        // 3.关闭流,释放资源
        fos.close();

    }

    /**
     * 数据追加续写
     *
     * @throws IOException
     */
    private static void method05() throws IOException {
        // 数据追加续写:
        // 1.创建FileOutputStream字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\fff\\a.txt", true);
        // 2.写出数据
        fos.write(99);
        // 3.关闭流,释放资源
        fos.close();
        System.out.println("搞定");
    }

    /**
     * 案例3:使用FileOutputStream字节输出流一次写出指定范围的字节数组的数据
     * public void write(byte[] b, int off, int len)
     *
     * @throws IOException
     */
    private static void method04() throws IOException {
        // 案例3:使用FileOutputStream字节输出流一次写出指定范围的字节数组的数据
        // 0. 创建一个字节数组
        byte[] bys = {97, 98, 99, 100};
        // 1.创建FileOutputStream字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\fff\\c.txt");
        // 2.写出数据
        fos.write(bys, 1, 2);
        // 3.关闭流,释放资源
        fos.close();
    }

    /**
     * 案例2:使用FileOutputStream字节输出流一次写出一个字节数组的数据
     * public void write(byte[] b)
     *
     * @throws IOException
     */
    private static void method03() throws IOException {
        // 案例2:使用FileOutputStream字节输出流一次写出一个字节数组的数据
        // 0. 创建一个字节数组
        byte[] bys = {97, 98, 99, 100};
        // 1.创建FileOutputStream字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\fff\\b.txt");
        // 2.写出数据
        fos.write(bys);
        // 3.关闭流,释放资源
        fos.close();
    }

    /**
     * 案例1: 使用FileOutputStream字节输出流一次写出一个字节数据
     * public abstract void write(int b)
     *
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 使用字节输出流写出字节数据:
        // 案例1: 使用FileOutputStream字节输出流一次写出一个字节数据
        // 1.创建FileOutputStream字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day10\\fff\\a.txt");
        // 2.写出数据
        fos.write(97);
        // 3.关闭流,释放资源
        fos.close();
        System.out.println("搞定");
    }

    /**
     * FileOutputStream类的构造方法
     *
     * @throws FileNotFoundException
     */
    private static void method01() throws FileNotFoundException {
        // 文件路径真实存在:
        // public FileOutputStream(String name): 创建字节输出流对象,通过参数指定一个文件路径
        String path = "day10\\fff\\a.txt";
        FileOutputStream fos1 = new FileOutputStream(path);

        // public FileOutputStream(File file)
        File file = new File(path);
        FileOutputStream fos2 = new FileOutputStream(file);

        // 文件路径不存在:
        /*// public FileOutputStream(String name): 创建字节输出流对象,通过参数指定一个文件路径
        String path = "day10\\fff\\b.txt";
        FileOutputStream fos1 = new FileOutputStream(path);

        // public FileOutputStream(File file)
        File file = new File("day10\\fff\\c.txt");
        FileOutputStream fos2 = new FileOutputStream(file);*/
    }
}
