package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo6_通过反射获取一个类的方法;

import java.lang.reflect.Method;

/**
 * @author 彭智林
 * @date 2018/1/2 11:06
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            通过反射获取一个类的方法:
                1.Method是方法类，类中的每一个方法都是Method的对象，通过Method对象可以调用方法。
                2.如何通过反射获取一个类的方法
                    Class类中的方法:
                        1. Method[] getMethods() 获取所有的public修饰的成员方法，包括父类中
                        2. Method[] getDeclaredMethods() 获取当前类中所有的方法，包含私有的，不包括父类中

                        3. Method getMethod("方法名", 方法的参数类型... 类型) 根据方法名和参数类型获得一个方法对象，只能是获取public修饰的
                        4. Method getDeclaredMethod("方法名", 方法的参数类型... 类型) 根据方法名和参数类型获得一个方法对象，包括private修饰的
                3.通过Method对象调用对应的方法:
                    Method类中的方法:
                        1. Object invoke(Object obj, Object... args)
                            参数1obj:调用成员方法的对象
                            参数2args:表示调用方法所需要的实参
                            如果obj=null，则表示该方法是静态方法

                       2. void setAccessible(true)
                            暴力反射，设置为可以直接调用私有修饰的成员方法
         */
        // 获取Zi类的Class对象
        Class clazz = Zi.class;

        // 如何通过反射获取一个类的方法:
        // 获取多个方法:
        // 1.获取所有的public修饰的成员方法，包括父类中
        Method[] methodsArr1 = clazz.getMethods();
        System.out.println(methodsArr1.length);// 12 因为Object类中有9个public修饰的方法
        System.out.println(Fu.class.getMethods().length);// 10 Fu类:1个  Object类:9个

        // 2.获取当前类中所有的方法，包含私有的，不包括父类中
        Method[] methodsArr2 = clazz.getDeclaredMethods();
        System.out.println(methodsArr2.length);// 3

        // 获取单个方法
        // 1.根据方法名和参数类型获得一个方法对象，只能是获取public修饰的
        // 获取test1方法的对象
        Method method1 = clazz.getMethod("test1");
        System.out.println(method1);

        // 获取test2方法的对象
        Method method2 = clazz.getMethod("test2", int.class);
        System.out.println(method2);

        // 2.根据方法名和参数类型获得一个方法对象，包括private修饰的
        // 获取test3方法的对象
        Method method3 = clazz.getDeclaredMethod("test3");
        System.out.println(method3);

        System.out.println("=============================");
        // 通过Method对象调用对应的方法:  非静态方法
        // 调用method1对象表示的test1方法:
        Zi zi = new Zi();
        method1.invoke(zi);

        // 调用method2对象表示的test2方法:
        Zi zi2 = new Zi();
        method2.invoke(zi2,100);

        // 调用method3对象表示的test3方法:
        method3.setAccessible(true);
        Zi zi3 = new Zi();
        method3.invoke(zi3);

        System.out.println("=============================");
        //  通过Method对象调用对应的方法: 静态方法
        Method method4 = clazz.getDeclaredMethod("test4", String.class);
        Method method5 = clazz.getDeclaredMethod("test5", String.class);
        System.out.println(method4);
        System.out.println(method5);

        // 调用method4对象表示的test4方法:
        method4.invoke(null,"test4方法执行了...");

        // 调用method5对象表示的test5方法:
        method5.setAccessible(true);
        method5.invoke(null,"test5方法执行了...");

    }
}
