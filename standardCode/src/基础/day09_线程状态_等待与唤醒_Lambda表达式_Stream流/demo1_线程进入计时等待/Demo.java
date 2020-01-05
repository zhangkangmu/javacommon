package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo1_线程进入计时等待;

/**
 * @author 彭智林
 * @date 2017/12/27 9:40
 */
public class Demo {
    public static void main(String[] args) {
        // 案例:执行10次打印Hello World!,每一次都暂停1秒
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World!");
            // 暂停1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
