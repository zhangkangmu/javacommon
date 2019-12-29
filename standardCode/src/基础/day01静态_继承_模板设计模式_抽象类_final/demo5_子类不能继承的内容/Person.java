package 基础.day01静态_继承_模板设计模式_抽象类_final.demo5_子类不能继承的内容;

/**
 * @author 彭智林
 * @date 2019/12/15 10:14
 */
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public Person() {
        System.out.println("空参");
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
