package 基础.day11_属性集_缓冲流_转换流_序列化流.demo11_序列化流ObjectOutputStream;

import java.io.Serializable;

/**
 * @author 彭智林
 * @date 2019/12/30 14:32
 */
public class Person implements Serializable {
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public int age;
    public transient int home;

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
