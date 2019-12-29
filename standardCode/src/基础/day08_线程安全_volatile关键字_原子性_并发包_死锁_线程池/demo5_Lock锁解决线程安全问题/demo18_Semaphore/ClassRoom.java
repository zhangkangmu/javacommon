package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo18_Semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 彭智林
 * @date 2019/12/25 16:25
 */
public class ClassRoom {
    Semaphore sp;

    public ClassRoom(Semaphore sp) {
        this.sp = sp;
    }

    public void into(){
        try {
            sp.acquire();// 获取许可
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 执行
        System.out.println(Thread.currentThread().getName()+":进入了into方法,时间为:"+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":准备释放,时间为:"+System.currentTimeMillis());
        sp.release();// 释放许可
    }
}
