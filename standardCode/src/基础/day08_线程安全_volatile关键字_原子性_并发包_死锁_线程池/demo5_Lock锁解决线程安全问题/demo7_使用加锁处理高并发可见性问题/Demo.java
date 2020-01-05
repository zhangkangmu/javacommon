package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo7_使用加锁处理高并发可见性问题;

/**
 * @author 彭智林
 * @date 2017/12/25 10:34
 */
public class Demo {
    public static void main(String[] args) {
        /*
              使用加锁处理高并发可见性问题:
                    线程加锁,就会清空工作内存,并且从主内存拷贝共享变量最新的值到工作内存成为副本
                    对主线程中的if结构进行加锁
         */
        // 创建并启动线程
        MyThread mt = new MyThread();
        mt.start();

        // 主线程
        while (true){
            synchronized (mt) {
                if(mt.flag == true){
                    break;// 只有当flag的值为true,就结束死循环
                }
            }
        }
    }
}
