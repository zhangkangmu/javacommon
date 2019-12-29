package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo20_线程池的使用;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 彭智林
 * @date 2019/12/25 17:16
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            线程池的使用:
                真正的线程池接口是java.util.concurrent.ExecutorService。
                使用java.util.concurrent.Executors线程工厂类里面提供了一些静态工厂，生成一些常用的线程池。
                Executors线程工厂类:
                    public static ExecutorService newFixedThreadPool(int nThreads);创建线程池对象,指定初始化线程数量

                往线程池中添加任务: 调用 ExecutorService线程池对象的方法
                    public Future<?> submit(Runnable task):从线程池中获取一个空闲的线程对象，来执行提交的任务. 提交并执行任务
                            返回值Future<?>: 用来获取线程执行任务后的结果   忽略
                            Runnable接口抽象方法: public abstract void run();实现run()方法其实就是指定线程任务,注意run方法没有返回值

                   public <T> Future<T> submit(Callable<T> task) : 从线程池中获取一个空闲的线程对象，来执行提交的任务. 提交并执行任务
                            返回值Future<?>: 用来获取线程执行任务后的结果
                                - V get() : 获取计算完成的结果。
                                使用Future对象调用get方法获取call()方法的返回值
                            Callable<V>接口抽象方法: public abstract V call(); 实现call()方法其实就是指定线程任务,注意call方法会有返回值
               线程池使用的步骤:
                    1.创建线程池对象,指定初始化线程数量
                    2.创建任务
                    3.提交任务到线程池中,并执行任务
                    4.关闭线程池(一般不操作)
         */
        // 提交的任务是实现Callable接口的任务:
       // 1.创建线程池对象,指定初始化线程数量
        ExecutorService es = Executors.newFixedThreadPool(3);
        // 2.创建任务
        MyCallable mc = new MyCallable();
       // 3.提交任务到线程池中,并执行任务
        Future<String> future = es.submit(mc);
        System.out.println("call方法返回的数据是:"+future.get());// null
        es.submit(mc);
        es.submit(mc);
        es.submit(mc);
        es.submit(mc);

        // 4.关闭线程池(一般不操作)
        es.shutdown();
    }

    /**
     *  提交的任务是实现Runnable接口的任务:
     */
    private static void method01() {
        // 提交的任务是实现Runnable接口的任务:
        // 1.创建线程池对象,指定初始化线程数量
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 2.创建任务
        MyRunnable mr = new MyRunnable();

        // 3.提交任务到线程池中,并执行任务
        es.submit(mr);
        es.submit(mr);
        es.submit(mr);
        es.submit(mr);

        // 4.关闭线程池(一般不操作)
//        es.shutdown();
    }
}
