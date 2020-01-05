package 基础.day08_线程安全_volatile关键字_原子性_并发包_死锁_线程池.demo5_Lock锁解决线程安全问题.demo8_volatile关键字处理高并发可见性问题;

/**
 * @author 彭智林
 * @date 2017/12/25 10:34
 */
public class Demo {
    public static void main(String[] args) {
        /*
           使用volatile关键字处理高并发可见性问题:
                volatile只能修饰成员变量或者类变量,不能修饰方法或者代码块
                格式: volatile 数据类型 变量名;

                volatile修饰多线程共享变量:
                  只要有线程修改了共享变量的值,并写回了主内存中,那么就会失效其他线程对此变量的副本,从而
                  重新到主内存中读取最新的值，放入到工作内存中

         */
        // 创建并启动线程
        MyThread mt = new MyThread();
        mt.start();

        // 主线程
        while (true){
            if(mt.flag == true){
                break;// 只有当flag的值为true,就结束死循环
            }
        }
    }
}
