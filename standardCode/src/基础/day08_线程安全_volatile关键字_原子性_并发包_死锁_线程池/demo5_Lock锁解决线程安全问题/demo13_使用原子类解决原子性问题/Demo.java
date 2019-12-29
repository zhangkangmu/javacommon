package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo13_使用原子类解决原子性问题;

/**
 * @author 彭智林
 * @date 2019/12/25 11:48
 */
public class Demo {
    public static void main(String[] args) {
        /*
           使用原子类解决原子性问题: 依赖cas比较交换机制
                CAS，Compare and Swap即比较并替换，CAS有三个操作数：内存值V、旧的预期值A、要修改的值B，
                当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，
                如果不相同则证明内存值在并发的情况下被其它线程修改过了，则不作任何修改，返回false，等待下次再修改。

         */
        // 创建并启动子线程
        MyThread mt = new MyThread();
        mt.start();

        // a变量自增3万次
        for (int i = 0; i < 100000; i++) {
            //相当于a++；
            mt.a.getAndIncrement();
        }

        // 暂定3秒,为了保证子线程执行完毕
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终a的值为:"+mt.a);// 期望:200000
    }
}
