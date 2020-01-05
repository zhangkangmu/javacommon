package 基础.day12_Socket网络编程_NIO.demo15_多路复用案例不发送数据;

/**
 * @author 彭智林
 * @date 2017/12/31 18:08
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        new Thread(() -> {
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                socketChannel.connect(new
                        InetSocketAddress("localhost", 7777));
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}