package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo21_线程池的练习;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 彭智林
 * @date 2017/12/25 17:40
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            线程池的练习:
                需求: 使用线程池方式执行任务,返回1-n的和
                分析:
                    任务:计算1-n的和,并且需要把累加和返回,所以任务应该是实现Callable接口
         */
        int n = 100;

        // 1.创建线程池对象,指定初始化线程数量
        ExecutorService es = Executors.newFixedThreadPool(1);
        // 2.创建任务
        Callable<Integer> cb = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // 计算1-n的和
                int sum = 0;
                for (int i = 0; i <= n; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 3.提交任务到线程池中,并执行任务
        Future<Integer> future = es.submit(cb);
        Integer sum = future.get();
        System.out.println("100的累加和:"+sum);// 100的累加和:5050

        // 4.关闭线程池(一般不操作)
    }
}
