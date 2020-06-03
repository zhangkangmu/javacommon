package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo14_ConcurrentHashMap;

/**
 * @author 彭智林
 * @date 2017/12/25 15:16
 */
public class Demo {
    public static void main(String[] args) {
        /*
            HashMap:多线程并发不安全
            Hashtable:多线程并发安全,使用的同步机制是锁,效率慢
            ConcurrentHashMap:多线程并发安全,使用的同步机制是cas+锁,效率高   推荐
            在理想状态下，ConcurrentHashMap 可支持16个线程执行并发写操作，及任意数量线程的读操作。
            JDK 1.7 中使用分段锁（ReentrantLock + Segment + HashEntry），相当于把一个 HashMap 分成多个段，每段分配一把锁，这样支持多线程访问。锁粒度：基于 Segment，包含多个 HashEntry。
            JDK 1.8 中使用 CAS + synchronized + Node + 红黑树。锁粒度：Node（首结点）（实现 Map.Entry<K,V>）。锁粒度降低了。
            案例:
                2条线程对同一个HashMap集合添加键值对,每一条线程添加100000个键值对到HashMap集合中,键不同
                HashMap集合中键值对个数期望的结果:200000对

            案例:
                2条线程对同一个ConcurrentHashMap集合添加键值对,每一条线程添加100000个键值对到HashMap集合中,键不同
                HashMap集合中键值对个数期望的结果:200000对
         */
        // 创建并启动2条线程
        new MyThread("线程1").start();
        new MyThread("线程2").start();

        // 保证以上2条线程都执行完毕,再来打印map集合中的键值对
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("map集合中键值对的个数:"+Const.map.size());// 200000
    }
}
