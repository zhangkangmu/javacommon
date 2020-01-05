package 基础.day11_属性集_缓冲流_转换流_序列化流.demo18_commonsio工具包;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 彭智林
 * @date 2017/12/30 16:14
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        /*
            commons-io工具包:
                概述:是apache开源基金组织提供的一组有关IO操作的类库，可以挺提高IO功能开发的效率
                使用步骤:
                    1.下载commons-io相关jar包；http://commons.apache.org/proper/commons-io/
                    2.解压下载后的commons-io压缩包
                    3.解压后,找到commons-io-2.6.jar文件,拷贝到Module下lib文件夹下
                    4.选中commons-io-2.6.jar文件,右键选择Add as Library把jar包添加到classPath路径下
                    5.使用commons-io-2.6.jar包里面的类
                常用API介绍:
                    - commons-io提供了一个工具类  org.apache.commons.io.IOUtils，封装了大量IO读写操作的代码。其中有两个常用方法：
                        1. public static int copy(InputStream in, OutputStream out)； 把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以下)
                        2. public static long copyLarge(InputStream in, OutputStream out)；把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数(适合文件大小为2GB以上)

                    - commons-io还提供了一个工具类org.apache.commons.io.FileUtils，封装了一些对文件操作的方法：
                        1. public static void copyFileToDirectory(final File srcFile, final File destFile) //复制文件到另外一个目录下。
                        2. public statisc void copyDirectoryToDirectory(File file1 ,File file2 );//复制file1目录到file2目录下
           */
        // 案例3: 使用commons.io.FileUtils拷贝一个文件夹到另一个文件夹中
        // 1.创建File对象,关联数据源文件夹路径
        File srcFile = new File("day11\\aaa");
        // 2.创建File对象,关联目的地文件夹路径
        File destFile = new File("day11\\ddd");
        // 3.使用FileUtils进行拷贝
        FileUtils.copyDirectoryToDirectory(srcFile,destFile);
    }

    /**
     *  案例2: 使用commons.io.FileUtils拷贝一个文件到一个文件夹中
     * @throws IOException
     */
    private static void method02() throws IOException {
        // 案例2: 使用commons.io.FileUtils拷贝一个文件到一个文件夹中
        // 1.创建File对象,关联数据源文件路径
        File srcFile = new File("day11\\aaa\\hb.jpg");

        // 2.创建File对象,关联目的地文件夹路径
        File destFile = new File("day11\\ddd");

        // 3.使用FileUtils工具类进行拷贝
        FileUtils.copyFileToDirectory(srcFile,destFile);
    }

    /**
     * 使用org.apache.commons.io.IOUtils工具类拷贝一个文件
     * @throws IOException
     */
    private static void method01() throws IOException {
        // 案例1: 使用org.apache.commons.io.IOUtils工具类拷贝一个文件
        // 1.创建字节输入流对象,关联数据源文件路径
        FileInputStream fis = new FileInputStream("day11\\aaa\\hb.jpg");

        // 2.创建字节输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day11\\ddd\\hbCopy1.jpg");

        // 3.使用IOUtils工具类调用copy方法进行拷贝
        IOUtils.copy(fis, fos);

        // 4.关闭流,释放资源
        fos.close();
        fis.close();
    }
}
