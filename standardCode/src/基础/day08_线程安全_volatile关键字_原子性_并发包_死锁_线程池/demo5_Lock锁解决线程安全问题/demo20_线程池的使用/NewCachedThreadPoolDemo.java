package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo20_线程池的使用;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 张宇洪
 * @date 2017/12/25 17:16
 */
public class NewCachedThreadPoolDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//全部一起执行
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"==="+ finalI);
				}
			});
		}
	}
}
