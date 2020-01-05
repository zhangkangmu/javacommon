package 基础.day12_Socket网络编程_NIO.demo16_多路复用发送数据;

/**
 * @author 彭智林
 * @date 2017/12/31 18:27
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client2 {
    public static void main(String[] args) {
        new Thread(() -> {
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                socketChannel.connect(new
                        InetSocketAddress("localhost", 8888));

                ByteBuffer buf = ByteBuffer.allocate(1024);
                buf.put("服务器你好,我是客户端8888...".getBytes());
                buf.flip();
                socketChannel.write(buf);

                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            SocketChannel socketChannel = null;
            try {
                socketChannel = SocketChannel.open();
                socketChannel.connect(new
                        InetSocketAddress("localhost", 9999));

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //1.先发一条
                ByteBuffer buf = ByteBuffer.allocate(100);
                buf.put("你好服务器，我是客户端9999....".getBytes());
                buf.flip();//limit设置为position,position设置为0
                socketChannel.write(buf);//输出从position到limit之间的数据



                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}