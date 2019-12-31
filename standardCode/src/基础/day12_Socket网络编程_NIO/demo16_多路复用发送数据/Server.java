package 基础.day12_Socket网络编程_NIO.demo16_多路复用发送数据;

/**
 * @author 彭智林
 * @date 2019/12/31 18:26
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        //1.同时监听三个端口：7777,8888,9999
        ServerSocketChannel serverChannel1 = ServerSocketChannel.open();
        serverChannel1.bind(new InetSocketAddress(7777));
        serverChannel1.configureBlocking(false);// 设置非阻塞

        ServerSocketChannel serverChannel2 = ServerSocketChannel.open();
        serverChannel2.bind(new InetSocketAddress(8888));
        serverChannel2.configureBlocking(false);

        ServerSocketChannel serverChannel3 = ServerSocketChannel.open();
        serverChannel3.bind(new InetSocketAddress(9999));
        serverChannel3.configureBlocking(false);

        //2.获取一个选择器
        Selector selector = Selector.open();

        //3.注册三个通道  注册服务端和客户端通道的 接收就绪事件

        serverChannel1.register(selector, SelectionKey.OP_ACCEPT);
        serverChannel2.register(selector, SelectionKey.OP_ACCEPT);
        serverChannel3.register(selector, SelectionKey.OP_ACCEPT);


        //4.循环监听三个通道
        boolean isRun = true;
        while (isRun) {
            System.out.println();
            System.out.println("等待客户端连接...");
            // 这个方法可能会阻塞，直到至少有一个已注册的事件发生,或者当一个或者更多的事件发生时
            int keyCount = selector.select();//阻塞的


            System.out.println("有一个客户端连接成功...");
            System.out.println("keyCount = " + keyCount);
            System.out.println("注册通道的数量 = " + selector.keys().size());
            System.out.println("已连接的数量 = " +
                    selector.selectedKeys().size());
            System.out.println();

            //遍历已连接的每个通道
            Set<SelectionKey> set2 = selector.selectedKeys();
            Iterator<SelectionKey> it = set2.iterator();
            /*ServerSocketChannel channel = null;
            SocketChannel socketChannel = null;*/
            while (it.hasNext()) {
                SelectionKey key = it.next();


                //接收数据(略)
                it.remove();
                //服务端的channel
                ServerSocketChannel serverChannel = null;
                //获得和客户端连接的通道
                SocketChannel socketChannel = null;
                //客户端请求连接事件
                if (key.isAcceptable()) {
                    serverChannel = (ServerSocketChannel) key.channel();
                    //获得服务端和客户端连接的通道
                    socketChannel = serverChannel.accept();
                    //将服务端和客户端连接的设置非阻塞
                    socketChannel.configureBlocking(false);
                    //注册服务端和客户端通道的读事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    //获取通道对象，方便后面将通道内的数据读入缓冲区
                    socketChannel = (SocketChannel) key.channel();
                    socketChannel.read(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(),0,buf.limit()));
                    Thread.sleep(5000);
                }
                System.out.println("休息1秒，等待下一个连接...");
                Thread.sleep(1000);
            }
        }

    }
}
