package 基础.day06_Collections_Set_Map_斗地主排序.demo9_TreeSet集合存储自定义类型的元素;

/**
 * @author 彭智林
 * @date 2019/12/22 9:04
 */
public class Person implements Comparable<Person> {
    public String name;
    public int age;
    public Person() {
    }
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


    @Override
    public int compareTo(Person o) {
        return this.age - o.age; // 按照年龄升序
    }
}
