package 基础.day01静态_继承_模板设计模式_抽象类_final.demo13_继承构造方法访问规则;

/**
 * @author 彭智林
 * @date 2019/12/15 11:52
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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

    /**
     * 吃饭的方法
     */
    public void eat(){
        System.out.println("吃饭的方法执行了...");
    }
}
