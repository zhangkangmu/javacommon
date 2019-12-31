package 基础.day12_Socket网络编程_NIO.demo4_案例1客户端发送字符串数据给服务端;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2019/12/31 11:53
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 服务端:
        // 1.创建ServerSocket对象,指定端口号 8888
        ServerSocket ss = new ServerSocket(8888);

        // 2.使用ServerSocket对象调用accpet()方法,接收请求,建立连接,返回socket对象
        //   如果连接不成功,该方法会一直阻塞
        Socket socket = ss.accept();

        // 3.使用返回的Socket对象获取输入流
        InputStream is = socket.getInputStream();

        // 4.读取数据
        byte[] bys = new byte[1000];
        int len = is.read(bys);
        System.out.println("接收到的数据:"+new String(bys,0,len));

        // 5.关闭流,释放资源
        socket.close();
//        ss.close();// 一般不关
    }
}
