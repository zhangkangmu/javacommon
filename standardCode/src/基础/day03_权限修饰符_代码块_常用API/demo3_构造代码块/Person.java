package 基础.day03_权限修饰符_代码块_常用API.demo3_构造代码块;

/**
 * @author 彭智林
 * @date 2019/12/18 9:09
 */
public class Person {

    public Person() {
        System.out.println("Person 空参构造...");
    }

    {
        System.out.println("构造代码块...");
    }

}
