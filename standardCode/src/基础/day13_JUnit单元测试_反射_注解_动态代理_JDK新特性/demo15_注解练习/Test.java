package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo15_注解练习;

import java.lang.reflect.Method;

/**
 * @author 彭智林
 * @date 2018/1/2 16:12
 */
public class Test {
    public static void main(String[] args) throws Exception{
        // 解析@MyTest注解,让@MyTest注解具有功能
        // 1.获取@Test注解所在的类的字节码对象 Demo类的字节码对象
        Class clazz = Demo.class;

        // 2.通过反射获取该类的所有方法
        Method[] methods = clazz.getDeclaredMethods();

        // 3.遍历所有的方法,判断是否有包含@MyTest注解的方法
        for (Method method : methods) {
            boolean flag = method.isAnnotationPresent(MyTest.class);
            if (flag == true) {
                // 5.如果有包含@MyTest注解的方法,就通过反射调用该方法执行
                Demo demo = (Demo) clazz.getConstructor().newInstance();
                method.invoke(demo);
            }
        }
    }
}
