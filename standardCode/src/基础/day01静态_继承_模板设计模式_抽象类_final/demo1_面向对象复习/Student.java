package 基础.day01静态_继承_模板设计模式_抽象类_final.demo1_面向对象复习;

/**
 * @author 彭智林
 * @date 2019/12/15 9:41
 */
public class Student {

    // 成员变量
    private String name;

    private int age;

    // set\get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 构造方法

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    // 成员方法

}
