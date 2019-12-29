package 基础.day01静态_继承_模板设计模式_抽象类_final.demo1_面向对象复习;

/**
 * @author 彭智林
 * @date 2019/12/15 9:14
 */
public class Person {

    // 成员变量
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    // 构造方法
    // 空参构造
    public Person(){

    }

    // 有参构造
    public Person(String name){
        this.name = name;
    }

    // 满参构造
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    // set\get方法
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    // 成员方法
    public void show(){
        System.out.println("我的姓名是:"+name+",我的年龄是:"+age);
    }


}
