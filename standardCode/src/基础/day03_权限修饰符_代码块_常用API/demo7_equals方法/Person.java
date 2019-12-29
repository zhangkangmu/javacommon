package 基础.day03_权限修饰符_代码块_常用API.demo7_equals方法;

import java.util.Objects;

/**
 * @author 彭智林
 * @date 2019/12/18 9:52
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
    public boolean equals(Object o) {
        // 如果需要比较的2个对象地址值相同,直接返回true,结束方法
        if (this == o) return true;
        // 如果传入的对象为null,或者要比较的2个对象类型不一致,就直接返回false,结束方法
        if (o == null || getClass() != o.getClass()) return false;
        // 说明要比较的2个对象一定是同类型,并且地址值不同,而且没有对象为null的情况
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name); // name.equals(person.name)
    }


}
