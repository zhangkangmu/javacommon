package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo18_方法引用;

/**
 * @author 彭智林
 * @date 2020/1/2 17:28
 * jdk8.0的新特性
 */
public class Demo {

    public static void printStr(){
        System.out.println("任务执行了...");
    }

    public static void main(String[] args) {
        /*
            方法引用:
                概述:方法引用就是用来在一定的情况下,替换Lambda表达式
                替换的场景:
                    如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
                    如果一个Lambda表达式大括号中的代码就是调用另一方法,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
         */
        // 创建线程并启动线程
        // 1.匿名内部类的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行了...");
            }
        }).start();

        // 2.Lambda表达式的方式
        new Thread(()->{System.out.println("任务执行了...");}).start();

        // 3.方法引用的方式:
        new Thread(()->{Demo.printStr();}).start();// 这个Lambda表达的大括号中其实就是调用Demo类的printStr()方法,符合方法引用替换Lambda表达式的场景

        new Thread(Demo::printStr).start();// 这个Lambda表达的大括号中其实就是调用Demo类的printStr()方法,符合方法引用替换Lambda表达式的场景



    }
}
