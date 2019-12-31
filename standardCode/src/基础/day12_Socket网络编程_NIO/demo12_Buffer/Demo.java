package 基础.day12_Socket网络编程_NIO.demo12_Buffer;

import java.nio.ByteBuffer;

/**
 * @author 彭智林
 * @date 2019/12/31 16:21
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Buffer:
                作用:应用程序不能直接对 Channel 进行读写操作，而必须通过 Buffer 来进行读写操作
                概述:Buffer实质上是一个数组，通常是一个字节数组，但也可以是其他类型的数组。
                分类: 基本数据类型除了boolean没有缓冲区
                    ByteBuffer
                    ShortBuffer
                    IntBuffer
                    LongBuffer
                    FloatBuffer
                    DoubleBuffer
                    CharBuffer
                ByteBuffer对象的创建方式:
                    - static ByteBuffer allocate(int capacity)  分配一个新的字节缓冲区。
                    - static ByteBuffer allocateDirect(int capacity) 分配新的直接字节缓冲区。
                    - static ByteBuffer wrap(byte[] array)  将 byte 数组包装到缓冲区中。

                缓冲区存取数据的两个核心方法:
                    - put();存入数据到缓冲区中
                    - get();获取缓冲区的数据

                缓冲区中的4个核心属性:
                    - capacity:代表缓冲区的最大容量，一般新建一个缓冲区的时候，limit的值和capacity的值默认是相等的。
                    - limit:代表有多少数据可以取出或有多少空间可以写入
                    - position:跟踪已经写了多少数据或读了多少数据，它指向的是下一个字节来自哪个位置

                    - mark:表示记录当前position位置,可以通过reset()恢复到mark的位置
                    - 关系:mark <= position <= limit <= capacity

                    获取属性值
                        capacity();
                        limit();
                        position();

                    常用方法:
                        - flip() 切换读取数据的模式
                        - mark()  在此缓冲区的位置设置标记。
                        - reset() 将此缓冲区的位置重置为以前标记的位置
                        - clear() 清空整个缓冲区
                        - rewind() 可以重复读;

                    使用Buffer缓冲区的步骤:
                        1.创建缓冲区
                        2.添加数据
                        3.调用flip()方法切换到读取模式
                        4.读取数据
                        5.清空缓冲区

                   写入模式,一直写,position会向后移
                   读取模式,一直读,position会向后移
         */
        ByteBuffer buf1 = ByteBuffer.allocate(10);// 缓冲区的大小为10

        System.out.println("=========allocate()======================");
        System.out.println("已经写了多少数据或读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出或有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        byte[] bytes = {97,98,99,100,101};
        // - put();存入数据到缓冲区中   写入模式
        buf1.put(bytes);
        System.out.println("=========put()======================");
        System.out.println("已经写了多少数据:" + buf1.position());// 5
        System.out.println("有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10


        // flip() 切换读取数据的模式
        buf1.flip();
        System.out.println("=========flip()======================");
        System.out.println("读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        // - get();获取缓冲区的数据
        // 读取2个字节
        byte[] bys = new byte[8];
        buf1.get(bys,0,2);
        System.out.println("=========get()======================");
        System.out.println("读了多少数据:" + buf1.position());// 2
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        buf1.rewind();// 重复读
        System.out.println("=========rewind()======================");
        System.out.println("读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        /*buf1.clear();
        System.out.println("=========clear()======================");
        System.out.println("读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10*/
    }

    /**
     *   - mark()  在此缓冲区的位置设置标记。
     *   - reset() 将此缓冲区的位置重置为以前标记的位置
     */
    private static void method03() {
        ByteBuffer buf1 = ByteBuffer.allocate(10);// 缓冲区的大小为10

        System.out.println("=========allocate()======================");
        System.out.println("已经写了多少数据或读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出或有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        byte[] bytes = {97,98,99,100,101};
        // - put();存入数据到缓冲区中   写入模式
        buf1.put(bytes);
        System.out.println("=========put()======================");
        System.out.println("已经写了多少数据:" + buf1.position());// 5
        System.out.println("有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10


        // flip() 切换读取数据的模式
        buf1.flip();
        System.out.println("=========flip()======================");
        System.out.println("读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        // - get();获取缓冲区的数据
        // 读取2个字节
        byte[] bys = new byte[8];
        buf1.get(bys,0,2);
        System.out.println("=========get()======================");
        System.out.println("读了多少数据:" + buf1.position());// 2
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        // mark()
        buf1.mark();// 标记

        buf1.get(bys,0,2);
        System.out.println("=========get()======================");
        System.out.println("读了多少数据:" + buf1.position());// 4
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        // 重置 reset()
        buf1.reset();
        System.out.println("=========reset()======================");
        System.out.println("读了多少数据:" + buf1.position());// 2
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10
    }

    /*
        put和get方法以及Buffer中的4个属性
     */
    private static void method2() {
        ByteBuffer buf1 = ByteBuffer.allocate(10);// 缓冲区的大小为10

        System.out.println("=========allocate()======================");
        System.out.println("已经写了多少数据或读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出或有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        byte[] bytes = {97,98,99,100,101};
        // - put();存入数据到缓冲区中   写入模式
        buf1.put(bytes);
        System.out.println("=========put()======================");
        System.out.println("已经写了多少数据:" + buf1.position());// 5
        System.out.println("有多少空间可以写入:" + buf1.limit());// 10
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10


        // flip() 切换读取数据的模式
        buf1.flip();
        System.out.println("=========flip()======================");
        System.out.println("读了多少数据:" + buf1.position());// 0
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10

        // - get();获取缓冲区的数据
        // 读取2个字节
        byte[] bys = new byte[8];
        buf1.get(bys,0,2);
        System.out.println("=========get()======================");
        System.out.println("读了多少数据:" + buf1.position());// 2
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10


        buf1.get(bys,0,2);
        System.out.println("=========get()======================");
        System.out.println("读了多少数据:" + buf1.position());// 4
        System.out.println("有多少数据可以取出:" + buf1.limit());// 5
        System.out.println("缓冲区的最大容量:" + buf1.capacity());// 10
    }

    /**
     * ByteBuffer对象的创建方式:
     */
    private static void method01() {
        //1.创建间接缓存区--缓存区是在：堆中：创建的快；访问的慢；   推荐
        ByteBuffer buf1 = ByteBuffer.allocate(10);// 缓冲区的大小为10

        //2.创建直接缓存区--系统内存：创建的慢；访问的快；
        ByteBuffer buf2 = ByteBuffer.allocateDirect(10);// 缓冲区的大小为10

        //3.根据一个已有的byte[]数组创建一个缓存区对象：间接缓存区
        byte[] byteArray = {97, 98, 99, 100};
        ByteBuffer buf3 = ByteBuffer.wrap(byteArray);
    }
}
