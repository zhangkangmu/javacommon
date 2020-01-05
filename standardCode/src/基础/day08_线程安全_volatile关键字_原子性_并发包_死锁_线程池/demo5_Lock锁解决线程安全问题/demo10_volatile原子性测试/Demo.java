package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo10_volatile原子性测试;

/**
 * @author 彭智林
 * @date 2017/12/25 11:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
            演示高并发原子性问题:
                例如: 一条子线程和一条主线程都对共享变量a进行++操作,每条线程对a++操作100000次
                    最终期望a的值为:200000
             volatile原子性测试: volatile关键字无法解决高并发原子性问题
           */
        // 创建并启动子线程
        MyThread mt = new MyThread();
        mt.start();

        // a变量自增3万次
        for (int i = 0; i < 100000; i++) {
            mt.a++;
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
