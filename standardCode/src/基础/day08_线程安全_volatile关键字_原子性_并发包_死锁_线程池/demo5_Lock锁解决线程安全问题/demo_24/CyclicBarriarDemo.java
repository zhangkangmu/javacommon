package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_24;

import java.util.concurrent.*;

/**
 * Created by zhangyuhong
 * Date:2020/7/21
 */
public class CyclicBarriarDemo {
    private static final Integer THREAD_SIZE = 3;

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Integer sum = 0;
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum10 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 1; i <= 100; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });
        System.out.println("sum10:" + sum10.get());

        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum20 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 101; i <= 200; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });

        ThreadPoolExecutor pool3 = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum30 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 201; i <= 300; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });
//        System.out.println("sum30:" + sum30.get());
        pool.shutdown();
        sum = sum10.get() + sum20.get() + sum30.get();
        System.out.println("sum:" + sum);
    }
}
