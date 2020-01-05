package 基础.day12_Socket网络编程_NIO.demo4_案例1客户端发送字符串数据给服务端;

/**
 * @author 彭智林
 * @date 2017/12/31 11:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
            案例1客户端发送字符串数据给服务端:
            客户端:
                1.创建Socket对象,指定要连接的服务器的ip和端口号
                2.使用Socket对象获取输出流
                3.写出字符串数据
                4.关闭流,释放资源

            服务端:
                1.创建ServerSocket对象,指定端口号
                2.使用ServerSocket对象调用accpet()方法,接收请求,建立连接,返回socket对象
                  如果连接不成功,该方法会一直阻塞
                3.使用返回的Socket对象获取输入流
                4.读取数据
                5.关闭流,释放资源
         */
    }
}
