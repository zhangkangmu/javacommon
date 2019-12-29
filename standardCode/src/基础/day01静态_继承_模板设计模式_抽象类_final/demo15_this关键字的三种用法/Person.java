package 基础.day01静态_继承_模板设计模式_抽象类_final.demo15_this关键字的三种用法;

/**
 * @author 彭智林
 * @date 2019/12/15 12:17
 */
public class Person {
    /**
     * 年龄
     */
    int age;

    public Person() {
        // 调用本类的有参构造方法
//        this(18);
        System.out.println("Person类的空参构造方法执行了....");
    }

    public Person(int age) {
        // 调用本类的空参构造方法
        this();
        this.age = age;
        System.out.println("Person类的有参构造方法执行了....");
    }


    public void eat(){
        System.out.println("吃饭");
        // 调用sleep()方法
        sleep();
        this.sleep();
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}
