package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo11_使用锁机制解决高并发原子性问题;

/**
 * @author 彭智林
 * @date 2017/12/25 11:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
            使用锁机制解决高并发原子性问题: 其实就是++操作的时候不要被其他线程打断
                对2条线程的a++操作进行加锁
         */
        // 创建并启动子线程
        MyThread mt = new MyThread();
        mt.start();

        // a变量自增3万次
        for (int i = 0; i < 100000; i++) {
            synchronized (mt) {
                mt.a++;
            }
        }

        // 暂定3秒,为了保证子线程执行完毕
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终a的值为:"+mt.a);// 期望:200000
    }
}
