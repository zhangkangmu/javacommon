package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo22_死锁;

/**
 * @author 彭智林
 * @date 2019/12/25 18:00
 */
public class ThreadB extends Thread {

    public ThreadB(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (Demo.BLOCK){
            System.out.println("B线程获取到了B锁,准备获取A锁:");
            synchronized (Demo.ALOCK){
                System.out.println(getName()+":执行代码");
            }
        }
    }
}
