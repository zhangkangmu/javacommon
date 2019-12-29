package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo3_同步方法解决线程安全问题;

/**
 * @author 彭智林
 * @date 2019/12/25 8:50
 */
public class Demo {
    public static void main(String[] args) {
        /*
            同步方法:
                概述:使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方法外等着。
                格式:
                    修饰符 synchronized 返回值类型 方法名(形参列表){

                    }
                同步方法的锁对象:
                    1.非静态同步方法的锁对象: this
                    2.静态同步方法的锁对象:该方法所在的类的字节码文件对象  类名.class
         */

        // 创建实现类对象
        MyRunnable mr = new MyRunnable();

        // 创建Thread线程对象,传入实现类对象,使用线程对象调用start()方法,启动线程,执行任务
        new Thread(mr,"窗口1").start();
        new Thread(mr,"窗口2").start();
        new Thread(mr,"窗口3").start();
        new Thread(mr,"窗口4").start();
    }
}
