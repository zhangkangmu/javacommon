package 基础.day12_Socket网络编程_NIO.demo14_SocketChannel的使用;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author 彭智林
 * @date 2017/12/31 17:40
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open())
        {
            serverChannel.bind(new InetSocketAddress(8888));

            System.out.println("【服务器】等待客户端连接...");
            SocketChannel accept = serverChannel.accept();//阻塞的
            System.out.println("【服务器】有连接到达...");

            //1.先发一条
            ByteBuffer outBuffer = ByteBuffer.allocate(100);
            outBuffer.put("你好客户端，我是服务器".getBytes());
            outBuffer.flip();//limit设置为position,position设置为0
            accept.write(outBuffer);//输出从position到limit之间的数据

            //2.再收一条，不确定字数是多少，但最多是100字节。先准备100字节空间
            ByteBuffer inBuffer = ByteBuffer.allocate(100);
            accept.read(inBuffer);
            inBuffer.flip();//limit设置为position,position设置为0
            String msg = new String(inBuffer.array(),0,inBuffer.limit());
            System.out.println("【服务器】收到信息：" + msg);
            accept.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
