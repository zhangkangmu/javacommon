package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo4_通过反射获取一个类的构造方法;

import java.lang.reflect.Constructor;

/**
 * @author 彭智林
 * @date 2018/1/2 10:05
 */
public interface Demo {
    public static void main(String[] args) throws Exception{
        /*
            通过反射获取一个类的构造方法:
                1.Constructor是构造方法类,任何一个类中的构造方法都可以封装成员一个Constructor的对象
                  所以可以使用Constructor类的对象调用封装的构造方法来创建类的对象
                2.怎么获取一个类的构造方法对应的Constructor对象
                    Class类中的方法:
                        - 批量获取构造方法对象：
                          - public Constructor[] getConstructors()：获取所有公有构造方法。
                          - public Constructor[] getDeclaredConstructors()：获取所有的构造方法，包括：公有、受保护、默认、私有。

                        - 获取单个：
                          - public Constructor getConstructor(Class… params)：获取某个公有构造方法。
                                                             Class类型的参数: 传入构造方法参数类型的字节码对象
                          - public Constructor getDeclaredConstructor(Class … params):*获取某个构造方法，可以是“公有，受保护、默认、私有”
                                                             Class类型的参数: 传入构造方法参数类型的字节码对象
                3.通过Constructor对象调用构造方法创建对象:
                    Constructor类中的方法:
                        newInstance(Object… params)：表示执行该Constructor对象表示的构造方法
                                    参数params:传入执行构造方法需要的实参
                        setAccessible(true): 暴力反射,允许反射
         */
        // 获取User类的字节码对象
        Class clazz = User.class;

        // 获取所有公共的构造方法:
        Constructor[] consArr1 = clazz.getConstructors();
        System.out.println(consArr1.length);// 2

        // 获取所有的构造方法:
        Constructor[] consArr2 = clazz.getDeclaredConstructors();
        System.out.println(consArr2.length);// 4

        // 获取单个公共的构造方法:
        Constructor constructor1 = clazz.getConstructor();
        Constructor constructor2 = clazz.getConstructor(String.class, int.class);

        // 获取单个私有的构造方法:
        Constructor constructor3 = clazz.getDeclaredConstructor(int.class);
        Constructor constructor4 = clazz.getDeclaredConstructor(String.class);

        // 使用constructor1调用newInstance方法
        User user1 = (User) constructor1.newInstance();

        // 使用constructor2调用newInstance方法
        User user2 = (User)constructor2.newInstance("张三",1);
        System.out.println(user2.name+"..."+user2.id);

        // 使用constructor3调用newInstance方法
        constructor3.setAccessible(true);// 暴力反射
        User user3 = (User) constructor3.newInstance(2);
        System.out.println(user3.id);// 2

    }
}
