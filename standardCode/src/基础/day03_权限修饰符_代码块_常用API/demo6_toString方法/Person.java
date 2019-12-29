package 基础.day03_权限修饰符_代码块_常用API.demo6_toString方法;

/**
 * @author 彭智林
 * @date 2019/12/18 9:37
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
