package hong.练习的包.day08_同步线程锁.test8;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 */
public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> integerCallable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for (int i=0;i<=100;i++){
                    sum+=i;
                }
                System.out.println(sum);
                return sum;
            }
        };
        executorService.submit(integerCallable);
        executorService.shutdown();
    }
}
