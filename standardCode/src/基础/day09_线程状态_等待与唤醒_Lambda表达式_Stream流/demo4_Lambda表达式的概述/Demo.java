package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo4_Lambda表达式的概述;

/**
 * @author 彭智林
 * @date 2017/12/27 11:03
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Lambda表达式的概述:
                它是一个JDK8开始一个新语法。它是一种“代替语法”——可以代替我们之前编写的“面向某种接口”编程的情况
            例如:通过实现Runnable接口的方式创建一条线程执行任务
                实现类:
                    1.创建一个实现类,实现Runnable接口
                    2.在实现类中,重写run()方法,把任务放入run()方法中
                    3.创建实现类对象
                    4.创建Thread线程对象,传入实现类对象
                    5.使用线程对象调用start()方法,启动并执行线程

                    总共需要5个步骤,一步都不能少,为什么要创建实现类,为了得到线程的任务

                匿名内部类:
                    1.创建Thread线程对象,传入Runnable接口的匿名内部类
                    2.在匿名内部类中重写run()方法,把任务放入run()方法中
                    3.使用线程对象调用start()方法,启动并执行线程

                     总共需要3个步骤,一步都不能少,为什么要创建Runnable的实现类,为了得到线程的任务

               以上2种方式都是通过Runnable接口的实现类对象,来传入线程需要执行的任务(面向对象编程)
               思考: 是否能够不通过Runnable接口的实现类对象来传入任务,而是直接把任务传给线程????
                    Lambda表达式

                函数式编程思想：
                    例如:在调用Thread()的构造方法,不需要定义实现类；不需要创建子类对象；只需要传入一个“方法”即可。
                    "方法": Lambda表达式

               面向对象和函数式编程:
                    面向对象: 必须依靠对象,使用对象调用方法来完成功能
                    函数式编程:不需要依靠对象,直接传入功能来执行即可(传入Lambda表达式)
                    Lambda表达式就是用来替换函数式接口的对象

         */
        // 实现类的方式:
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();

        // 匿名内部类的方式:
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的方式创建线程的任务执行了");
            }
        });
        t2.start();

        // 体验Lambda表达式的方式:
        Thread t3 = new Thread(()->{System.out.println("Lambda表达式的方式");});
        t3.start();
    }
}
