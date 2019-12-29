package 基础.day06_Collections_Set_Map_斗地主排序.demo14_HashMap存储自定义类型;

import java.util.Objects;

/**
 * @author 彭智林
 * @date 2019/12/22 15:13
 */
public class Student {
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
