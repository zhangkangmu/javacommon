package 基础.day12_Socket网络编程_NIO.demo1_UDP通信程序;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 彭智林
 * @date 2019/12/31 11:02
 */
public class Receive {// 接收端

    public static void main(String[] args)throws Exception {
        // 接收端:  8888
        // 1.创建一个数据包对象,用来接收数据
        byte[] bys = new byte[100];
        DatagramPacket dp = new DatagramPacket(bys,bys.length);

        // 2.创建DatagramSocket对象来接收数据包
        DatagramSocket ds = new DatagramSocket(8888);
        ds.receive(dp);

        // 3.通过数据包获取数据
        // 获取接收到了多少个字节数据
        int len = dp.getLength();
        System.out.println("接收到的数据是:"+new String(bys,0,len));

        InetAddress ip = dp.getAddress();
        System.out.println("发送端的ip地址是:"+ip);

        // 4.释放资源
        ds.close();
    }
}
