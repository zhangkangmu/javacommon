package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyuhong
 * Date:2020/12/27
 *
 * 自定义线程池,队列和线程数大于任务数--报错(策略:DiscardOldestPolicy ： 抛弃队列最前面的任务，然后重新尝试执行任务。)
 *
 */
public class TestThreadPoolExecutor5 {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
				1, 0L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(2),  //不指定决策的话,最多三个任务,不然就报错了
				Executors.defaultThreadFactory(),//线程工厂
				new ThreadPoolExecutor.DiscardOldestPolicy()//抛弃队列最前面的任务，然后重新尝试执行任务。
				 );

		threadPoolExecutor.execute(new TaskRunable("线程1"));
		threadPoolExecutor.execute(new TaskRunable("线程2"));
		threadPoolExecutor.execute(new TaskRunable("线程3"));
		threadPoolExecutor.execute(new TaskRunable("线程4"));
		threadPoolExecutor.execute(new TaskRunable("线程5"));
		threadPoolExecutor.execute(new TaskRunable("线程6"));

	}
}


