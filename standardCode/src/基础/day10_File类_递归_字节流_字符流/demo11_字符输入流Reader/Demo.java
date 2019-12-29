package 基础.day10_File类_递归_字节流_字符流.demo11_字符输入流Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2019/12/28 16:10
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            字符输入流Reader: 抽象类
                概述:Reader是一个字符输入流,用来以字符为单位读取字符数据,所有字符输入流的顶层父类
                Reader抽象类中定义了所有字符输入流共有的方法:
                    - public void close() ：关闭此流并释放与此流相关联的任何系统资源。
                    - public int read()： 读取单个字符并返回,如果读取到了末尾,就返回-1
                    - public int read(char[] cbuf)： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。
                                                    返回的是读取到的字符个数,如果读取到了末尾就返回-1

                由于Reader是抽象类,无法创建对象,所以得使用它的子类: FileReader类
                 FileReader类:
                    概述:是一个字符输入流,用来以字符为单位读取字符数据
                    构造方法:
                        - FileReader(String fileName)： 创建字符输入流对象,传入一个String类型的数据源文件路径。
                        - FileReader(File file)： 创建字符输入流对象,传入一个File对象形式的数据源文件路径。 。
                      注意:如果指定的数据源文件路径不存在,就会报文件找不到异常
                案例1:使用字符输入流一次读取一个字符数据
                案例2:使用字符输入流一次读取一个字符数组长度的字符数据
         */
        // 案例2:使用字符输入流一次读取一个字符数组长度的字符数据
        // 1. 创建字符输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day10\\hhh\\a.txt");

        // 2. 创建一个字符数组,用来存储读取到的字符数据
        char[] chs = new char[3];

        // 2. 定义一个int类型的变量,用来存储读取到的字符个数
        int len;

        // 3. 循环读取
        while ((len = fr.read(chs)) != -1){
            System.out.println(new String(chs,0,len));
        }

        // 4. 关闭流,释放资源
        fr.close();

    }

    /**
     * 案例1:使用字符输入流一次读取一个字符数据
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 案例1:使用字符输入流一次读取一个字符数据
        // 1. 创建字符输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day10\\hhh\\a.txt");

        // 2. 定义一个变量用来存储读取到的字符数据
        int len;

        // 3. 循环读取字符数据
        while ( (len = fr.read()) != -1){
            System.out.println((char)len);
        }

        // 4. 关闭流,释放资源
        fr.close();
    }

    /**
     * FileReader类的概述和构造方法
     * @throws FileNotFoundException
     */
    private static void method01() throws FileNotFoundException {
        // 文件路径真实存在:
        FileReader fr1 = new FileReader("day10\\hhh\\a.txt");

        // 文件路径不存在:
        FileReader fr2 = new FileReader("day10\\hhh\\b.txt");// 报异常FileNotFoundException
    }
}
