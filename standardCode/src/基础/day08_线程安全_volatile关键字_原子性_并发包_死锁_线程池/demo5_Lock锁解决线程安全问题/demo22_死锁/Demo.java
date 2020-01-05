package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo22_死锁;

/**
 * @author 彭智林
 * @date 2017/12/25 17:57
 */
public class Demo {

    static final Object ALOCK = new Object();// A锁
    static final Object BLOCK = new Object();// B锁

    public static void main(String[] args) {
        /*
            死锁:
                3.1什么是死锁
                    在多线程程序中,使用了多把锁,造成线程之间相互等待.程序不往下走了。
                    简而言之:A线程拿了B线程需要的锁,B线程拿了A线程需要的锁

                3.2产生死锁的条件
                    1.有多把锁
                    2.有多个线程
                    3.有同步代码块嵌套
                3.3 实现死锁:
                    案例:
                        A线程需要先获得A锁,再获得B锁,然后才能执行代码
                        B线程需要先获得B锁,再获得A锁,然后才能执行代码
                        这种场景就有可能会出现死锁
         */
        // 创建A线程,启动并执行
        new ThreadA("A线程").start();
        // 创建B线程,启动并执行
        new ThreadB("B线程").start();
    }
}
