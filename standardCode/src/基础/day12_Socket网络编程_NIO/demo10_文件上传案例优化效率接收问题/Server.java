package 基础.day12_Socket网络编程_NIO.demo10_文件上传案例优化效率接收问题;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2017/12/31 12:25
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //  1.创建ServerSocket对象,指定端口号 8888
        ServerSocket ss = new ServerSocket(8888);

        while (true){
            //  2.调用accept()方法,接收请求,建立连接,返回Socket对象
            Socket socket = ss.accept();// 阻塞

            // 开启线程去读写操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 读写操作
                    InputStream is = null;
                    FileOutputStream fos = null;
                    try {
                        //  3.使用Socket对象获取输入流对象,关联连接通道
                        is = socket.getInputStream();

                        //  4.创建输出流对象,关联目的地文件路径
                        fos = new FileOutputStream("day12\\"+System.currentTimeMillis()+".jpg");

                        //  5.定义一个字节数组,用来存储读取到的字节数据
                        byte[] bys = new byte[8192];

                        //  5.定义一个int类型的变量,用来存储读取到的字节个数
                        int len;

                        System.out.println("server");
                        //  6.循环读取
                        while ((len = is.read(bys)) != -1) { // 卡死
                            // 卡死=====>while循环没有结束
                            // while循环什么时候结束?
                            // 客户端不再写数据到通道中,或者 客户端关闭了
                            //  7.写出数据
                            fos.write(bys, 0, len);
                        }

                        System.out.println("====服务器回写信息======");
                        // 1.通过Socket对象获得输出流
                        OutputStream os = socket.getOutputStream();

                        // 2.写出信息到通道中("文件上传成功!")
                        os.write("文件上传成功!".getBytes());

                    }catch (Exception e){

                    }finally {
                        //  8.释放资源
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                if (is != null) {
                                    is.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }
    }
}
