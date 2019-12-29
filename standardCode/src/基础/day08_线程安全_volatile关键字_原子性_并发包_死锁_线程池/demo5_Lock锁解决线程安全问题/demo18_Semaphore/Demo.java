package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo18_Semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 彭智林
 * @date 2019/12/25 16:19
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Semaphore:
                Semaphore的主要作用是控制线程的并发数量,可以控制在某个时间段内，有几个线程可以同时访问一个方法
                构造方法:
                    public Semaphore(int permits)	permits 表示许可线程的数量
                成员方法:
                    public void acquire() throws InterruptedException	表示获取许可
                    public void release()							  表示释放许可
                案例:实现只允许5个线程同时调用ClassRoom类中的into()方法
                分析:
                    1.创建一个ClassRoom类,在该类中定义一个into方法
                    2.ClassRoom类中的into方法在开始的时候,应该调用acquire()方法,获取许可,执行完代码,需要调用release()方法进行释放许可
                        public void into(){
                            semaphore.acquire(); // 获取许可
                            //.. 执行代码
                            semaphore.release();// 释放许可
                        }
                    3.创建线程类,重写run()方法,在run()方法中调用ClassRoom类的into方法

         */
        // 创建Semaphore类的对象,指定许可线程数量为5
        Semaphore sp = new Semaphore(2);
        // 创建ClassRoom类的对象,传入Semaphore类的对象
        ClassRoom cr = new ClassRoom(sp);
        // 创建多条线程,传入ClassRoom类的对象,启动线程
        new MyThread(cr).start();
        new MyThread(cr).start();
        new MyThread(cr).start();
        new MyThread(cr).start();
        new MyThread(cr).start();
        new MyThread(cr).start();
    }
}
