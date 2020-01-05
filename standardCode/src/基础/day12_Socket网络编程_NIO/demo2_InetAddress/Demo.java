package 基础.day12_Socket网络编程_NIO.demo2_InetAddress;

import java.net.InetAddress;

/**
 * @author 彭智林
 * @date 2017/12/31 10:55
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            InetAddress(IP地址类):此类表示互联网协议 (IP) 地址。
                        静态方法:
                            static InetAddress getLocalHost() 返回本地主机的ip地址对象
                            static InetAddress getByName(String host) 根据主机名获取ip地址对象
                        成员方法:
                             String getHostName()  获取此 IP 地址的主机名。
                             String getHostAddress() 返回 IP 地址字符串
         */
        // 获取本地的ip地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("本地的ip地址对象:"+ip1);// 本地的ip地址对象:pengzhilin-PC/192.168.65.57

        InetAddress ip2 = InetAddress.getByName("pengzhilin-PC");
        System.out.println("本地的ip地址对象:"+ip2);// 本地的ip地址对象:pengzhilin-PC/192.168.65.57

        InetAddress ip3 = InetAddress.getByName("baidu.com");
        System.out.println(ip3);// baidu.com/220.181.38.148

        // 获取主机名
        System.out.println("ip1对象中的主机名:"+ip1.getHostName());// pengzhilin-PC
        // 获取ip地址
        System.out.println("ip1对象中的ip地址:"+ip1.getHostAddress());// 192.168.65.57
    }
}
