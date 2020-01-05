package 基础.day11_属性集_缓冲流_转换流_序列化流.demo16_打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author 彭智林
 * @date 2017/12/30 15:15
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            打印流: java.io.PrintStream 输出流
                1.包  java.io
                2.概述:该类能够方便地打印各种数据类型的值，是一种便捷的输出方式
                3.构造方法:
                    public PrintStream(String fileName)： 使用指定的文件名创建一个新的打印流。
                                    参数fileName:指定打印的文件路径
                4.成员方法:
                    println(XXX);
                    print(XXX)
         */
        // 需求: 改变系统输出 System.out.println();默认打印到控制台,现在我要打印到day11\\ccc\ps2.txt文件中
//        System.out.println();
//        PrintStream ps = System.out;// 获取系统的PrintStream对象
//        ps.println("jack");// 打印到控制台

        // 1.创建PrintStream对象,关联目的地文件路径
        PrintStream ps = new PrintStream("day11\\ccc\\ps2.txt");

        // 2.修改System类中的out属性的值为我们自己创建的PrintStream对象
        System.setOut(ps);

        // 3.打印输出
        System.out.println("jack");
    }

    /**
     * PrintStream的使用
     *
     * @throws FileNotFoundException
     */
    private static void method01() throws FileNotFoundException {
        // 1.创建PrintStream对象,关联目的地文件路径
        PrintStream ps = new PrintStream("day11\\ccc\\ps.txt");
        // 2.打印数据到目的地文件路径中
        ps.println("静夜思");
        ps.println("床前明月光");
        ps.println("疑是地上霜");
        ps.println("举头望明月");
        ps.println("低头思故乡");
        ps.print(100);
        ps.print("哈哈哈");
        ps.print(3.14);

        // 3.关流,释放资源
        ps.close();
    }
}
