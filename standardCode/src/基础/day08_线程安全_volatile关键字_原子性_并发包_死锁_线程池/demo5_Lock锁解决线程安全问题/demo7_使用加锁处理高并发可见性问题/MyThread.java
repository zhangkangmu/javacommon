package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo7_使用加锁处理高并发可见性问题;

/**
 * @author 彭智林
 * @date 2019/12/25 10:34
 */
public class MyThread extends Thread {

    boolean flag = false;// 主和子线程共享变量

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 把flag的值改为true
        flag = true;
        System.out.println("修改后flag的值为:"+flag);

    }
}
