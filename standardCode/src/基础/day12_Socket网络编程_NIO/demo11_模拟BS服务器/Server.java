package 基础.day12_Socket网络编程_NIO.demo11_模拟BS服务器;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 彭智林
 * @date 2019/12/31 15:08
 */
public class Server {
    public static void main(String[] args) throws Exception {
        /*
            需求:
                模拟网站服务器，使用浏览器访问自己编写的服务端程序，查看网页效果。

            本机ip地址: 127.0.0.1  localhost

         */
        // 1.获取浏览器请求页面的路径
        // 1.1 创建ServerSocket对象,指定端口号为9999
        ServerSocket ss = new ServerSocket(9999);

        while (true){
            // 1.2 调用accept(),接收浏览器的请求,建立连接,返回socket对象
            Socket socket = ss.accept();

            // 开启线程下载
            new Thread(new Runnable() {
                @Override
                public void run() {
                    InputStream is = null;
                    FileInputStream fis = null;
                    OutputStream os = null;
                    try {
                        // 1.3 通过socket对象获取输入流
                        is = socket.getInputStream();

                        // 1.4 读取连接通道中的信息
                        // 测试: 先取通道中读取8192个字节数据,看看有没有请求页面路径?
                        // 通过测试,我们发现浏览器请求页面路径在第一行,所以需要读取第一行数据
       /* byte[] bys = new byte[8192];
        int len = is.read(bys);
        System.out.println(new String(bys,0,len));*/
        /*
            GET /day12/web/index.html HTTP/1.1
            Host: localhost:9999
            Connection: keep-alive
            Upgrade-Insecure-Requests: 1
            User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36
            Sec-Fetch-User: ?1
            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,* *;q=0.8,application/signed-exchange;v=b3;q=0.9
                    Sec-Fetch-Site: none
                    Sec-Fetch-Mode: navigate
                    Accept-Encoding: gzip, deflate, br
                    Accept-Language: zh-CN,zh;q=0.9
                    Cookie: Idea-7071e3d8=cc177568-5581-4562-aeac-26fcb6ca7e56; Idea-fcda2818=3d8dd3f2-aa56-46e8-9f7a-ab77973cad91

         */
                        // 转换输入流是字符流,创建转换输入流需要传入一个字节输入流
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String line = br.readLine();// GET /day12/web/index.html HTTP/1.1

                        // 1.5 根据第一行信息获取请求页面路径
                        String path = line.split(" ")[1].substring(1);
                        System.out.println("请求页面路径:" + path);// 请求页面路径:day12/web/index.html


                        // 2.读取浏览器请求页面的数据
                        // 2.把请求页面回写给浏览器
                        // 2.1 创建字节输入流对象,关联浏览器请求页面路径
                        fis = new FileInputStream(path);

                        // 2.2 通过socket对象获取输出流,关联连接通道
                        os = socket.getOutputStream();

                        // 2.3 定义一个字节数组,用来存储读取到的字节数据
                        byte[] bys = new byte[8192];

                        // 2.3 定义一个int类型的变量,用来存储读取到的字节个数
                        int len;

                        // 固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        // 2.4 循环读取
                        while ((len = fis.read(bys)) != -1) {
                            // 2.5 在循环中,写出数据
                            os.write(bys,0,len);
                        }

                    }catch (Exception e){

                    }finally {
                        // 2.6 关闭流,释放资源
                        try {
                            if (os != null) {
                                os.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                if (fis != null) {
                                    fis.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }).start();
        }
    }
}
