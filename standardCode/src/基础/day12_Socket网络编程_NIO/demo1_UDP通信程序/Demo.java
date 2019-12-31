package 基础.day12_Socket网络编程_NIO.demo1_UDP通信程序;

/**
 * @author 彭智林
 * @date 2019/12/31 10:30
 */
public class Demo {
    public static void main(String[] args) {
        /*
            UDP通信程序:
                - UDP协议的特点:
                  - 面向无连接
                  - 发送端发送数据,可以不管接收端是否启动,照样可以发送数据
                  - 传输数据不安全,传输速度快
                  - 每个数据包的大小是64K以内
                  - 传输数据是以数据包的形式进行传输数据

                - UDP协议的应用场景:
                  - 视频会议
                  - qq聊天
                  - ....

                - UDP通信程序相关的类: DatagramPacket(数据包类)   DatagramSocket(发送和接收的Socket)
                    DatagramPacket(数据包类):用来封装要发送的数据或者要接收的数据  类似:集装箱
                    DatagramSocket(发送和接收的Socket类):用来发送和接收数据包     类似:码头

                UDP通信程序的步骤:
                    发送端:
                        1.发送端需要把数据封装到数据包中
                        2.使用DatagramSocket对象发送数据包
                    接收端:
                        1.创建一个数据包对象,用来接收数据
                        2.创建DatagramSocket对象来接收数据包
                        3.通过数据包获取数据

                DatagramPacket(数据包类)API:
                    构造方法:
                          * DatagramPacket(byte[] buf, int length, InetAddress address, int port) 创建发送端数据包对象
                            * buf：要发送的内容，字节数组
                            * length：要发送内容的长度，单位是字节
                            * address：接收端的IP地址对象
                            * port：接收端的端口号
                        * DatagramPacket(byte[] buf, int length) 创建接收端的数据包对象
                            * buf：用来存储接收到内容
                            * length：能够接收内容的长度
                    成员方法:
                            * int getLength() 获得实际接收到的字节个数
	                        * InetAddress getAddress() 获取ip地址对象

                DatagramSocket(发送和接收的Socket类)API:
                   构造方法:
                          * DatagramSocket() 创建发送端的Socket对象，系统会随机分配一个端口号。
                          * DatagramSocket(int port) 创建接收端的Socket对象并指定端口号
                   成员方法:
                         * void send(DatagramPacket dp) 发送数据包
                         * void receive(DatagramPacket p) 接收数据包
                         *  void close() 关闭此数据报套接字。

               InetAddress(IP地址类):此类表示互联网协议 (IP) 地址。
                        静态方法:
                            static InetAddress getLocalHost() 返回本地主机的ip地址对象
                            static InetAddress getByName(String host) 根据主机名获取ip地址对象
                        成员方法:
                             String getHostName()  获取此 IP 地址的主机名。
                              String getHostAddress() 返回 IP 地址字符串
         */
    }
}
