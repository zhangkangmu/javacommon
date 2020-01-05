package hong.练习的包.day07_线程;

/**
 * Created by zhangyuhong
 * Date:2017/12/24
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("集成Thread线程");
        myThread.start();

        new Thread(new MyRunable(),"实现Runable线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"：--"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"匿名内部类线程").start();


        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + "：--" + j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
