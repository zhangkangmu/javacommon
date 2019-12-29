package 基础.day09_线程状态_等待与唤醒_Lambda表达式_Stream流.demo11_Stream综合案例;

/**
 * @author 彭智林
 * @date 2019/12/27 16:43
 */
public class Person {
    /**
     * 姓名
     */
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
