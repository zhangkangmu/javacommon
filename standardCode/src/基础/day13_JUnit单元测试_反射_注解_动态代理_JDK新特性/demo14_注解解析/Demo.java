package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo14_注解解析;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 彭智林
 * @date 2020/1/2 15:53
 */
public class Demo {
    @Test
    @MyAnnotation1
    public void show() throws Exception{
        /*
            注解解析: java.lang.reflect.AnnotatedElement接口
                AnnotatedElement接口的实现类: Class、Method、Field、Constructor等
                AnnotatedElement接口的方法:
                    - T getAnnotation(Class<T> annotationType):得到指定类型的注解引用。没有返回null。
                    - boolean isAnnotationPresent(Class<?extends Annotation> annotationType)：判断指定的注解有没有。

         */
        // 获得一个注解对象:
        // 例如:获取show方法上面的MyAnnotation1注解对象
        // 1.获取Demo类的字节码对象
        Class clazz = Demo.class;

        // 2.获取show方法的Method对象
        Method methodShow = clazz.getMethod("show");

        // 3.使用show方法的Method对象调用getAnnotation()方法获取该注解对象
        MyAnnotation1 annotation = methodShow.getAnnotation(MyAnnotation1.class);
        System.out.println(annotation);// @com.itheima.demo14_注解解析.MyAnnotation1()

        // 判断是否包含指定的注解:
        // 例如:判断show()方法上面是否包含MyAnnotation1注解
        System.out.println(methodShow.isAnnotationPresent(MyAnnotation1.class));

    }


}
