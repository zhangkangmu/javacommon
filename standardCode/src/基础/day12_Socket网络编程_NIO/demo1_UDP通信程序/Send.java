package 基础.day12_Socket网络编程_NIO.demo1_UDP通信程序;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 彭智林
 * @date 2017/12/31 11:02
 */
public class Send {// 发送端

    public static void main(String[] args) throws Exception{
        // 发送端:
        // 0.定义要发送的数据
        String str = "abcdef";
        byte[] bys = str.getBytes();

        // 1.发送端需要把数据封装到数据包中
        // 1.1.创建DatagramPacket对象,传入要发送的数据,并指定接收端的ip地址和端口号
        DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getLocalHost(),8888);

        // 3.使用DatagramSocket对象发送数据包
        // 3.1 创建DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();

        // 3.2 使用DatagramSocket对象调用send()方法进行发送数据包
        ds.send(dp);

        // 4.释放资源
        ds.close();
    }
}
