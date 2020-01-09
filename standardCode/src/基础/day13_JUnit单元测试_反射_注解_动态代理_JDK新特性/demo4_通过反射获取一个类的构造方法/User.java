package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo4_通过反射获取一个类的构造方法;

/**
 * @author 彭智林
 * @date 2018/1/2 10:12
 */
public class User {

    String name;

    int id;

    public User(){
        System.out.println("User 空参构造方法...");
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private User(int id) {
        this.id = id;
    }

    private User(String name) {
        this.name = name;
    }


}


