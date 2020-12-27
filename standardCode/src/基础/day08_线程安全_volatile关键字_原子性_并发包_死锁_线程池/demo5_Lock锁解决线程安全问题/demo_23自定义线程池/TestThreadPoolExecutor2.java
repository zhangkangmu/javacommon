package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyuhong
 * Date:2020/12/27
 *
 * 自定义线程池,队列和线程数大于任务数--报错  (没有指定决策策略)
 */
public class TestThreadPoolExecutor2 {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
				1, 0L,   //一次只能执行一次,剩下的放在队列里,也就是最多3个不报错,max如果是2就加多一个不会报错
				TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(2));
		threadPoolExecutor.execute(new TaskRunable("线程1"));
		threadPoolExecutor.execute(new TaskRunable("线程2"));
		threadPoolExecutor.execute(new TaskRunable("线程3"));
		threadPoolExecutor.execute(new TaskRunable("线程4"));
	}
}


