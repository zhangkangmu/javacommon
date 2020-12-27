package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

import java.util.concurrent.*;

/**
 * Created by zhangyuhong
 * Date:2020/5/30
 *
 * 简单使用说明
 *
 *
 * 为什么要用这个自定义线程池
 * 因为其他四种Executor的线程池的
 * FixedThreadPool和SingleThreadPool的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
 *
 * CachedThreadPool允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
 */
public class TestThreadPoolExecutor {
    private static ExecutorService pool;

    public static void main(String[] args) {
        pool = new ThreadPoolExecutor(
                1,//核心大小
                2,//最大线程数
                1000,//1000
                TimeUnit.MILLISECONDS,//ms
                new ArrayBlockingQueue<Runnable>(1),
//                new SynchronousQueue<Runnable>(),//队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//决绝策略，直接抛异常
                // 直接丢弃，并抛出RejectedExecutionException异常
                // RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
                // 丢弃任务，不会抛异常
                // RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
                // 不丢弃当前job，换而丢弃workQueue中最老的job
                // RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
                // 不异步去执行job，当前线程直接同步去执行这个job
                //  RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
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
