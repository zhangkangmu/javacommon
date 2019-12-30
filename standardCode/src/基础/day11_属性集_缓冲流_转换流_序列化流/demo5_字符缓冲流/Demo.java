package 基础.day11_属性集_缓冲流_转换流_序列化流.demo5_字符缓冲流;

import javax.annotation.processing.Filer;
import java.io.*;

/**
 * @author 彭智林
 * @date 2019/12/30 10:51
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            字符缓冲流:BufferedReader，BufferedWriter
                字符缓冲输入流:BufferedReader  Reader子类
                字符缓冲输出流:BufferedWriter  Writer子类

                构造方法:
                    - public BufferedReader(Reader in) ：创建一个 新的缓冲输入流。
                    - public BufferedWriter(Writer out)： 创建一个新的缓冲输出流。
                特有方法:
                    - BufferedReader：public String readLine(): 读一行文字。如果已到达流末尾，则返回 null
                    - BufferedWriter：public void newLine(): 写一行行分隔符,由系统属性定义符号。
                案例1:每次读取一行数据的方式,读取一个文件中的所有数据
                案例2:往一个文件中写一首诗
         */
        // 案例2:往一个文件中写一首诗
        // 1.创建字符缓冲输出流对象,关联目的地文件路径
        FileWriter fw = new FileWriter("day11\\aaa\\c.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        // 2.写出数据
        bw.write("静夜思");
        bw.newLine();

        bw.write("床前明月光");
        bw.newLine();

        bw.write("疑是地上霜");
        bw.newLine();

        bw.write("举头望明月");
        bw.newLine();

        bw.write("低头思故乡");

        // 3.关闭流,释放资源
        bw.close();
    }

    /**
     * 案例1:每次读取一行数据的方式,读取一个文件中的所有数据
     *
     * @throws IOException
     */
    private static void method01() throws IOException {
        // 案例1:每次读取一行数据的方式,读取一个文件中的所有数据
        // 1.创建字符缓冲输入流对象,关联数据源文件路径
        FileReader fr = new FileReader("day11\\aaa\\b.txt");
        BufferedReader br = new BufferedReader(fr);

        // 2.定义一个String类型的变量,用来存储读取到的一行数据
        String line = null;

        // 3.循环读取(只要读取到的数据不为null,说明就还可以继续读)
        while ((line = br.readLine()) != null) {
            // 4.在循环中,打印读取到的数据
            System.out.println(line);
        }

        // 5.关闭流,释放资源
        br.close();
    }
}
