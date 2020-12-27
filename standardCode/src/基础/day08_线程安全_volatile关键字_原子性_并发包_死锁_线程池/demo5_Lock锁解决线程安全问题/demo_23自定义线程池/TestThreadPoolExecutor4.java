package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyuhong
 * Date:2020/12/27
 *
 * 自定义线程池,队列和线程数大于任务数--报错(策略:该任务被线程池拒绝，由调用 execute方法的线程执行该任务。)
 *
 * **************最合适使用的线程池***************
 */
public class TestThreadPoolExecutor4 {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
				1, 0L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(2),
				Executors.defaultThreadFactory(),//线程工厂
				new ThreadPoolExecutor.CallerRunsPolicy()//该任务被线程池拒绝，由调用 execute方法的线程执行该任务
				 );

		threadPoolExecutor.execute(new TaskRunable("线程1"));
		threadPoolExecutor.execute(new TaskRunable("线程2"));
		threadPoolExecutor.execute(new TaskRunable("线程3"));
		threadPoolExecutor.execute(new TaskRunable("线程4"));
		threadPoolExecutor.execute(new TaskRunable("线程5"));
		threadPoolExecutor.execute(new TaskRunable("线程6"));

		System.out.println("任务运行结束");
	}
}


