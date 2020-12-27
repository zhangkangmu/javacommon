package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo_23自定义线程池;

/**
 * Created by zhangyuhong
 * Date:2020/12/27
 */
public class TaskRunable implements Runnable{
	private  String taskName;

	public TaskRunable(String taskName) {
		this.taskName=taskName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"---"+taskName);

	}
}
