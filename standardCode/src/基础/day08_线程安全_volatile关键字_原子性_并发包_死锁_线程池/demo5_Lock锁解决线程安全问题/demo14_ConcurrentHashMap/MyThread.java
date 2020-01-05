package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo14_ConcurrentHashMap;

/**
 * @author 彭智林
 * @date 2017/12/25 15:20
 */
public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 往Const类的map集合中添加10万个键值对,键不同
        for (int i = 0; i < 100000; i++) {
            Const.map.put(getName()+i,getName()+i);
        }
        System.out.println(getName()+":执行完毕...");
    }
}
