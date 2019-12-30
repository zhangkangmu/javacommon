package 基础.day11_属性集_缓冲流_转换流_序列化流.demo13_序列化流的注意事项;

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
    public transient int age;// 表明这个属性不用序列化
    /**
     * 宠物
     */
    public Animal anl;

    public Person(String name, int age, Animal anl) {
        this.name = name;
        this.age = age;
        this.anl = anl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", anl=" + anl +
                '}';
    }
}
