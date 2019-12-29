package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo6_高并发可见性问题;

/**
 * @author 彭智林
 * @date 2019/12/25 10:34
 */
public class Demo {
    public static void main(String[] args) {
        /*
            高并发可见性问题:
                一个线程对共享变量进行了修改,但是另一个线程读取不到修改的值
                简而言之:一条线程修改了共享变量的值,对其他线程是不可见的

            处理高并发可见性问题:
                使用加锁处理高并发可见性问题
                使用volatile关键字处理高并发可见性问题

         */
        // 创建并启动线程
        MyThread mt = new MyThread();
        mt.start();

        // 主线程
        while (true){
            if(mt.flag == true){
                break;// 只有当flag的值为true,就结束死循环
            }
        }
    }
}
