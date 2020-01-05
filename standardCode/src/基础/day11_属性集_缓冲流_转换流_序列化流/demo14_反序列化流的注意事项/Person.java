package 基础.day11_属性集_缓冲流_转换流_序列化流.demo14_反序列化流的注意事项;


import java.io.Serializable;

/**
 * @author 彭智林
 * @date 2017/12/30 14:32
 */
public class Person implements Serializable {

    static final long serialVersionUID = 42L;// 序列化版本号

    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public  int age;
    /**
     * 钱
     */
    public double money;

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
