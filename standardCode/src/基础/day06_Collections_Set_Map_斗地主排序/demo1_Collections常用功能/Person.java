package 基础.day06_Collections_Set_Map_斗地主排序.demo1_Collections常用功能;

/**
 * @author 彭智林
 * @date 2019/12/22 9:04
 */
public class Person implements Comparable<Person>{
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
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
        // 排序规则:按照年龄降序排序
        // 前减后 升序
        // 后减前 降序
        // 前: 调用这个方法的对象 this
        // 后: 参数  o
        return o.age - this.age;
    }
}
