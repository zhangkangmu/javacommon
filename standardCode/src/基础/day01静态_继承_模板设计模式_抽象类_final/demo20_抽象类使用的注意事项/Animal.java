package 基础.day01静态_继承_模板设计模式_抽象类_final.demo20_抽象类使用的注意事项;

/**
 * @author 彭智林
 * @date 2019/12/15 15:19
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
        System.out.println("Animal 类的空参构造...");
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

    public void sleep(){
        System.out.println("两眼一闭,就睡着了...");
    }
}
