package 基础.day11_属性集_缓冲流_转换流_序列化流.demo3_缓冲流的概述;

/**
 * @author 彭智林
 * @date 2019/12/30 9:59
 */
public class Demo {
    public static void main(String[] args) {
        /*
            缓冲流的概述:
                缓冲流,也叫高效流，是对4个基本的FileXxx 流的增强，所以也是4个流，按照数据类型分类：
                    - 字节缓冲流：BufferedInputStream，BufferedOutputStream
                    - 字符缓冲流：BufferedReader，BufferedWriter

               缓冲流的基本原理:是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
                              通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

         */
    }
}
