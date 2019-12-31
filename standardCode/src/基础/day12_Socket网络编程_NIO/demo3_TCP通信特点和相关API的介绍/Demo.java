package 基础.day12_Socket网络编程_NIO.demo3_TCP通信特点和相关API的介绍;

/**
 * @author 彭智林
 * @date 2019/12/31 11:17
 */
public class Demo {
    public static void main(String[] args) {
        /*
            - TCP协议的特点:
              - 面向连接
              - 发送端和接收端必须建立连接,才能传输数据,也就意味着得先启动接收端
              - 发送端主动连接接收端,接收端不会主动连接发送端
              - 传输数据安全,传输速度慢
              - 传输数据的大小无限制
              - 传输数据是以流的形式传输

            - TCP协议的应用场景:
              - 文件上传和下载
              - 浏览网页
              - ...

            TCP程序通信相关的类: Socket  ServerSocket
                Socket:表示客户端的套接字            类似:深圳的码头
                ServerSocket:表示服务端的套接字      类似:香港的码头

            Socket类的API:
                构造方法:
                    * Socket(String host, int port) 根据ip地址字符串和端口号创建客户端Socket对象
                        * 注意事项：只要执行该方法，就会立即连接指定的服务器程序，如果连接不成功，则会抛出异常。
                            如果连接成功，则表示三次握手通过。
                    * Socket(InetAddress address, int port) 根据ip地址对象和端口号创建客户端Socket对象
                成员方法:
                     * OutputStream getOutputStream(); 获得字节输出流对象
                     * InputStream getInputStream();获得字节输入流对象
                     void shutdownOutput() 禁用此套接字的输出流。

            ServerSocket类的API:
                构造方法:
                  * ServerSocket(int port) 创建服务端套接字,指定端口号
                成员方法:
                  * Socket accept() 等待客户端连接,如果三次握手成功,就返回一个Socket对象,表示连接建立成功
                                    如果没有客户端连接成功,那么这个方法就会一直阻塞
         */
    }
}
