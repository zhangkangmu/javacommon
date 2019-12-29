package hong.练习的包.z其他;

/**
 * Created by zhangyuhong
 * Date:2019/12/22
 */
public class Person implements Comparable<Person>{
    public int age;
    public String name;

    public Person( String name,int age) {
        this.age = age;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}
