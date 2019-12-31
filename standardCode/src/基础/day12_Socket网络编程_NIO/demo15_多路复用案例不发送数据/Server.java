package 基础.day12_Socket网络编程_NIO.demo15_多路复用案例不发送数据;

/**
 * @author 彭智林
 * @date 2019/12/31 18:08
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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

        //3.注册三个通道 注册服务端和客户端通道的 接收连接就绪事件
        SelectionKey key1 = serverChannel1.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key2 = serverChannel2.register(selector, SelectionKey.OP_ACCEPT);
        SelectionKey key3 = serverChannel3.register(selector, SelectionKey.OP_ACCEPT);

        //4.循环监听三个通道
        boolean isRun = true;
        while (isRun) {
            System.out.println();
            System.out.println("等待客户端连接...");
            // 这个方法可能会阻塞，直到至少有一个已注册的事件发生,或者当一个或者更多的事件发生时
            int keyCount = selector.select();//阻塞的

            System.out.println("有一个客户端连接成功...");
            System.out.println("keyCount = " + keyCount);
            System.out.println("注册通道的数量 = " + selector.keys().size());// 3
            System.out.println("已连接的数量 = " +
                    selector.selectedKeys().size());
            System.out.println();

            //遍历已连接的每个通道
            // 获取所有已连接的通道
            Set<SelectionKey> set2 = selector.selectedKeys();
            Iterator<SelectionKey> it = set2.iterator();//迭代器
            while (it.hasNext()) {
                SelectionKey key = it.next();// 获得一个连接就绪事件发送的通道对应的key
                System.out.println("获取通道...");
                //获得服务端的channel  发送了注册事件的通道
                ServerSocketChannel channel =
                        (ServerSocketChannel) key.channel();
                System.out.println("等待【" + channel.getLocalAddress() + "】通道数据...");
                // 获得服务端和客户端连接的通道
                SocketChannel socketChannel = channel.accept();// 建立连接

                //接收数据(略)....

                // 删除
                it.remove();
            }
            System.out.println("休息1秒，等待下一个连接...");
            Thread.sleep(1000);
        }
    }
}