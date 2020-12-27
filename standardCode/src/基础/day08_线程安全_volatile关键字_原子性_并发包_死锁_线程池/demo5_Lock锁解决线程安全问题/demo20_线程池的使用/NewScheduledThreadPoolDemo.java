package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo20_线程池的使用;

import java.util.concurrent.*;

/**
 * @author 张宇洪
 * @date 2017/12/25 17:16
 */
public class NewScheduledThreadPoolDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//2条2条一起执行
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			scheduledExecutorService.schedule(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"==="+ finalI);
				}
			},3, TimeUnit.SECONDS);
		}
	}
}
