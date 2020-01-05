package 基础.day02_static_接口_多态_内部类.demo22_引用类型作为方法参数和返回值;

/**
 * @author 彭智林
 * @date 2017/12/16 16:24
 */
public class Person {
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("姓名是:"+name+",年龄是:"+age);
    }
}
