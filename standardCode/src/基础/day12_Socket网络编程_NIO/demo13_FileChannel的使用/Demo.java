package 基础.day12_Socket网络编程_NIO.demo13_FileChannel的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 彭智林
 * @date 2019/12/31 17:28
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        String src = "day12\\hb.jpg";
        String dst = "day12\\hbCopy6.jpg";

        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(src));
        FileOutputStream fo=new FileOutputStream(new File(dst));

        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();

        //获得容器buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);// 缓冲区数组

        while(inChannel.read(buffer) != -1){
            //判断是否读完文件
            //重设一下buffer的position=0
            buffer.flip();// 切换到读取模式
            //开始写
            outChannel.write(buffer);

            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }

        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();

}
}
