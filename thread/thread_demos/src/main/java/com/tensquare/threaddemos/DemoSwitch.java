package com.tensquare.threaddemos;
/*
*
1. 开关有两个状态（开，关）
2. 目的：我们要通过对线程的调度让开关不能被连续的打开或者关闭
3. 执行过程：
   1. 假设关闭线程先获取到开关锁
      1. 如果开关是关闭的，通过aSwitch.wait();方法让当前关闭线程释放锁进入waiting状态
         1. 开启的线程获取到aSwitch锁
         2. 执行设置开关打开
         3. 通过notify唤醒关闭的线程
            1. 锁再次被开启的线程获取，aSwitch.wait()让开启的线程等待
            2. 锁被关闭的线程获取了，关闭开关，唤醒开启线程
      2. 如果开关是开启的，就继续执行设置开关关闭，通过aSwitch.notify()唤醒一个其他正在处于同一把锁waiting状态的线程
* */
public class DemoSwitch {

    static class Switch{
        //开关状态
        Boolean state = false;

        public Boolean getState() {
            return state;
        }

        public void setState(Boolean state) {
            String s = state?"打开":"关闭";
            System.out.println(s);
            if(this.state==state){
                System.out.println("开关不能连续"+s);
            }
            this.state = state;
        }
    }

    static abstract class ActionThread implements Runnable{
        //开关
        Switch aSwitch;

        public ActionThread(Switch aSwitch) {
            this.aSwitch = aSwitch;
        }

        @Override
        public void run() {
            //循环
            while (true){
                //同步
                synchronized (aSwitch){
                    action();
                }
            }
        }

        protected abstract void action();
    }

    public static void main(String[] args) {
        //1.创建开关
        Switch aSwitch = new Switch();
        //2.关闭线程
        Thread thread1 = new Thread(new ActionThread(aSwitch){
            @Override
            protected void action() {
                //RUNNABLE
                System.out.println("thread1获取到aSwitch对象的锁后:"+Thread.currentThread().getState().name());
                //如果开关是关闭的
                if(!this.aSwitch.getState()){
                    try {
                        //让当前线程释放锁，进入等待
                        this.aSwitch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //关闭开关
                this.aSwitch.setState(false);
                //唤醒等待中的一个线程
                this.aSwitch.notify();
            }
        });
        //new
        System.out.println("创建thread1未运行时的状态是:"+thread1.getState().name());
        //2.打开线程
        Thread thread2 = new Thread(new ActionThread(aSwitch){
            @Override
            protected void action() {
                //BLOCKED
                System.out.println("thread2获取到aSwitch对象的锁后:"+thread1.getState().name());
                //如果开关是打开的
                if(this.aSwitch.getState()){
                    try {
                        //让当前线程释放锁，进入等待
                        this.aSwitch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //打开开关
                this.aSwitch.setState(true);
                //waiting
                System.out.println("thread2线程在调用notify之前:"+thread1.getState().name());
                //唤醒等待中的一个线程
                this.aSwitch.notify();

            }
        });
        thread1.start();
        thread2.start();
    }
}