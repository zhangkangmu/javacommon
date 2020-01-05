package 基础.day12_Socket网络编程_NIO.demo5_案例2服务器向客户端回写数据;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2017/12/31 11:53
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

        System.out.println("====客户端开始接收服务器回写的数据:=====");
        // 1.通过socket对象获取输入流
        InputStream is = socket.getInputStream();

        // 2.读取数据
        byte[] bys = new byte[1000];
        int len = is.read(bys);
        System.out.println("接收到的数据:"+new String(bys,0,len));


        // 4.关闭流,释放资源
        socket.close();
    }
}
