package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

import java.util.concurrent.*;

/**
 * Created by zhangyuhong
 * Date:2020/5/30
 */
public class TestThreadPoolExecutor {
    private static ExecutorService pool;

    public static void main(String[] args) {
        pool = new ThreadPoolExecutor(
                1,//核心大小
                2,//最大线程数
                1000,//1000
                TimeUnit.MILLISECONDS,//ms
                new SynchronousQueue<Runnable>(),//队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//决绝策略，直接抛异常
        );
        for (int i = 0; i < 3; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }
}
