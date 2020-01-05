package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo17_CyclicBarrier;

/**
 * @author 彭智林
 * @date 2017/12/25 16:07
 */
public class MeetingThread extends Thread {
    @Override
    public void run() {
        System.out.println("好,都到齐了,会议开始...");
    }
}
