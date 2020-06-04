package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo8_threadLocal解决可见性问题;

/**
 * Created by zhangyuhong
 * Date:2020/6/3
 */
public class Demo {
    public static void main(String[] args) {
        // 创建并启动线程
        MyThread mt = new MyThread();
        mt.start();

        // 主线程
        while (true){
            if(MyThread.th.get() == true){
                break;// 只有当flag的值为true,就结束死循环
            }
        }
    }
}
