package 基础.day01静态_继承_模板设计模式_抽象类_final.demo2_继承的格式;

/**
 * @author 彭智林
 * @date 2017/12/15 10:01
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public void sleep(){
        System.out.println("睡觉的方法执行了...");
    }

    public void eat(){
        System.out.println("吃东西的方法执行了...");
    }
}
