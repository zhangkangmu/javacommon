package 基础.day10_File类_递归_字节流_字符流.demo12_字符输出流Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2017/12/28 16:41
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            字符输出流Writer: 抽象类
                概述:java.io.Writer类是表示字符输出流,用来以字符为单位写出数据,是所有字符输出流的顶层父类
                 字符输出流Writer定义了所有字符输出流的共有方法:
                    - public abstract void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
                    - public abstract void flush() ：刷新此输出流并强制任何缓冲的输出字符被写出。

                    - public void write(int c) ：写出一个字符。
                    - public void write(char[] cbuf)：将 b.length字符从指定的字符数组写出此输出流。
                    - public abstract void write(char[] b, int off, int len) ：从指定的字符数组写出 len字符，从偏移量 off开始输出到此输出流。
                    - public void write(String str) ：写出一个字符串。
                    - public void write(String str, int off, int len) 写入字符串的某一部分。

                由于Writer是抽象类,无法创建对象,所以得创建其子类对象: FileWriter
                FileWriter类:
                    概述:表示字符输出流,用来以字符为单位写出数据
                    构造方法:
                         - public FileWriter(String name)： 创建字符输出流,以字符串的形式传入目的地文件路径
                        - public FileWriter(File file)：创建字符输出流,以File对象的形式传入目的地文件路径
                        注意:
                            当你创建一个流对象时，必须传入一个文件路径:
                                1.该路径下，如果没有这个文件，会创建该文件。
                                2.如果有这个文件，会清空这个文件的数据。

                   数据追加续写:
                        - public FileWriter(String name, boolean append)： 创建字符输出流,以字符串的形式传入目的地文件路径。
                        - public FileWriter(File file, boolean append)： 创建字符输出流,以File对象的形式传入目的地文件路径。

                        注意: boolean类型的参数传入的是true,那么写出数据的时候就是拼接,否则就是覆盖
                案例1:使用字符输出流写出一个字符数据
                案例2:使用字符输出流写出一个字符数组数据
                案例3:使用字符输出流写出一个字符串数据
                案例4:关闭和刷新方法的区别
                    - flush ：刷新缓冲区，流对象可以继续使用。
                    - close ：关闭流，释放系统资源。关闭前会刷新缓冲区,关闭之后流不可以继续使用

         */
        // 关闭和刷新方法的区别:
        // 1.创建字符输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\kkk\\d.txt");

        // 2.写出一个字符串
        fw.write("中国深圳市");

        // 3.关闭流,释放资源
//        fw.close(); // 关闭流,并刷新缓冲区
//        fw.write("宝安区");// 关闭流后,流不能继续使用

        fw.flush();// 刷新缓冲区
        fw.write("宝安区");// 刷新缓冲区后,流可以继续使用
        fw.flush();



    }

    /**
     * 案例3:使用字符输出流写出一个字符串数据
     * public void write(String str)
     * public void write(String str, int off, int len)
     * @throws IOException
     */
    private static void method04() throws IOException {
        // 案例3:使用字符输出流写出一个字符串数据
        // 1.创建字符输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\kkk\\c.txt");

        // 2.写出一个字符串
        fw.write("中国深圳市");
        // 2.写出一个字符串的一部分
        fw.write("中国深圳市宝安区",5,3);

        // 3.关闭流,释放资源
        fw.close();
    }

    /**
     * 案例2:使用字符输出流写出一个字符数组数据
     * public void write(char[] cbuf)
     * public abstract void write(char[] b, int off, int len)
     *
     * @throws IOException
     */
    private static void method03() throws IOException {
        //  案例2:使用字符输出流写出一个字符数组数据
        // 1.创建字符输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\kkk\\b.txt");
        // 2.写出字符数组
        char[] chs = {'a', 'b', 'c', '中', '国'};
        // 2.1 把chs字符数组中的所有字符全部写入到文件中
        fw.write(chs);
        // 2.2 把chs字符数组中的'b','c','中'写入到文件中
        fw.write(chs, 1, 3);

        // 3.关闭流,释放资源
        fw.close();
    }

    /**
     * 案例1:使用字符输出流写出一个字符数据
     * public void write(int c) ：写出一个字符。
     *
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 案例1:使用字符输出流写出一个字符数据
        // 1.创建字符输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\kkk\\b.txt");
        // 2.写出单个字符
        fw.write('a');
        fw.write('中');
        fw.write('国');
        // 3.关闭流,释放资源
        fw.close();
    }

    private static void method01() throws IOException {
        // 创建字符输出流,以字符串的形式传入目的地文件路径
        // FileWriter fw1 = new FileWriter("day10\\kkk\\a.txt");
        // FileWriter fw2 = new FileWriter("day10\\kkk\\b.txt");

        //  数据追加续写:
        FileWriter fw1 = new FileWriter("day10\\kkk\\a.txt", true);
        fw1.write('a');
        fw1.close();
    }
}
