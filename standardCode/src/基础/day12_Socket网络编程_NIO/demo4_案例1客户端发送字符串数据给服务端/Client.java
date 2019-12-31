package 基础.day12_Socket网络编程_NIO.demo4_案例1客户端发送字符串数据给服务端;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2019/12/31 11:53
 */
public class Client {
    public static void main(String[] args) throws Exception{
        // 客户端:
        // 1.创建Socket对象,指定要连接的服务器的ip和端口号
//        Socket socket = new Socket("127.0.0.1",8888);
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        // 2.使用Socket对象获取输出流
        OutputStream os = socket.getOutputStream();

        // 3.写出字符串数据
        os.write("服务器,约吗?".getBytes());

        // 4.关闭流,释放资源
        socket.close();
    }
}
