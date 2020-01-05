package 基础.day12_Socket网络编程_NIO.demo6_案例3客户端上传文件给服务器;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2017/12/31 12:25
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //  1.创建ServerSocket对象,指定端口号 8888
        ServerSocket ss = new ServerSocket(8888);

        //  2.调用accept()方法,接收请求,建立连接,返回Socket对象
        Socket socket = ss.accept();

        //  3.使用Socket对象获取输入流对象,关联连接通道
        InputStream is = socket.getInputStream();

        //  4.创建输出流对象,关联目的地文件路径
        FileOutputStream fos = new FileOutputStream("day12\\hbCopy2.jpg");

        //  5.定义一个字节数组,用来存储读取到的字节数据
        byte[] bys = new byte[8192];

        //  5.定义一个int类型的变量,用来存储读取到的字节个数
        int len;

        //  6.循环读取
        while ((len = is.read(bys)) != -1) {
            //  7.写出数据
            fos.write(bys, 0, len);
        }
        //  8.释放资源
        fos.close();
        is.close();
    }
}
