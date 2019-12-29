package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo20_线程池的使用;

import java.util.concurrent.Callable;

/**
 * @author 彭智林
 * @date 2019/12/25 17:34
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 任务
        System.out.println("Hello World....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务结束了...");
        return "itheima";
    }
}
