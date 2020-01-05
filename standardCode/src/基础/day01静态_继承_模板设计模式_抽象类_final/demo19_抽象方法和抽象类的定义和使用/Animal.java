package 基础.day01静态_继承_模板设计模式_抽象类_final.demo19_抽象方法和抽象类的定义和使用;

/**
 * @author 彭智林
 * @date 2017/12/15 15:19
 */
public abstract class Animal {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private  int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
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
     * eat()抽象方法
     */
    public abstract void eat();
}
