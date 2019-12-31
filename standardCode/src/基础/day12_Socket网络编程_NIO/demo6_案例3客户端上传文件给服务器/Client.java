package 基础.day12_Socket网络编程_NIO.demo6_案例3客户端上传文件给服务器;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2019/12/31 12:25
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //  1.创建Socket对象,指定要连接的服务器的ip地址和端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //  2.创建输入流对象,关联数据源文件路径(要上传的文件的路径)
        FileInputStream fis = new FileInputStream("day12\\hb.jpg");

        //  3.通过Socket对象获取输出流,关联连接通道
        OutputStream os = socket.getOutputStream();

        //  4.定义一个字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        //  4.定义一个int类型的变量,用来存储读取到的字节个数
        int len;

        //  5.循环读取
        while ((len = fis.read(bys)) != -1) {
            //  6.写出数据
            os.write(bys,0,len);
        }
        //  7.释放资源
        os.close();
        fis.close();
    }
}
