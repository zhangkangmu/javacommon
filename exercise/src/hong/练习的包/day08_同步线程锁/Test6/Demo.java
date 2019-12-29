package hong.练习的包.day08_同步线程锁.Test6;

import java.util.concurrent.Semaphore;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 * 问老师，为什么要用classroom
 */
public class Demo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
new Thread1(semaphore,"第一个人").start();
new Thread1(semaphore,"第2个人").start();
new Thread1(semaphore,"第3个人").start();
new Thread1(semaphore,"第4个人").start();
    }
}
