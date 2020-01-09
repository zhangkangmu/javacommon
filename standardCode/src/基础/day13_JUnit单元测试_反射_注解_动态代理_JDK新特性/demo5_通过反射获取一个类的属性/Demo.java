package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo5_通过反射获取一个类的属性;

import java.lang.reflect.Field;

/**
 * @author 彭智林
 * @date 2018/1/2 10:45
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            通过反射获取一个类的属性:
                1.Field是属性类，类中的每一个属性都是Field的对象，通过Field对象可以给对应的属性赋值和取值。
                2.如何通过反射获取一个类的属性:
                    Class类中的方法:
                        1. Field[] getFields() 获取所有的public修饰的属性对象，返回数组
                        2. Field[] getDeclaredFields() 获取所有的属性对象，包括private修饰的，返回数组

                        3. Field getField(String name) 根据属性名获得属性对象，只能获取public修饰的
                        4. Field getDeclaredField(String name) 根据属性名获得属性对象，包括private修饰的
                3.通过Field对象给对应的属性赋值和取值:
                    Field类中的方法:
                        set(Object obj,Object value);通用方法都是给对象obj的属性设置使用
                                    参数1obj: 表示要赋值的属性的对象
                                    参数2value: 表示属性的值
                        get(Object obj); 通用方法是获取对象obj对应的属性值的
                                    参数obj: 要获取的属性的对象
                        void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性
         */
        // 获取Teacher类的字节码对象
        Class clazz = Teacher.class;

        // 通过反射获取一个类的属性:
        // 1.获取所有的public修饰的属性对象，返回数组
        Field[] arr1 = clazz.getFields();
        System.out.println(arr1.length);// 2

        // 2.获取所有的属性对象，包括private修饰的，返回数组
        Field[] arr2 = clazz.getDeclaredFields();
        System.out.println(arr2.length);// 3

        // 3.根据属性名获得属性对象，只能获取public修饰的
        Field field1 = clazz.getField("id");
        System.out.println(field1);

        Field field2 = clazz.getField("name");
        System.out.println(field2);

        // 4.根据属性名获得属性对象，包括private修饰的
        Field field3 = clazz.getDeclaredField("salary");
        System.out.println(field3);



        // 通过Field对象给对应的属性赋值和取值:
        // 给field1对象对应的属性赋值
        Teacher t1 = new Teacher();
        field1.set(t1,1);// 意思:给t1对象的id属性赋值为1
        // 获取field1对象对应的属性值
        Object o = field1.get(t1);// 意思:获取t1对象的id属性值
        System.out.println("id:"+o);// id:1


        System.out.println("=================");
        // 给field2对象对应的属性赋值
        Teacher t2 = new Teacher();
        field2.set(t2,"张三");// 意思:给t2对象的name属性赋值为张三
        // 获取field1对象对应的属性值
        Object o2 = field2.get(t2);// 意思:获取t2对象的name属性值
        System.out.println("name:"+o2);// name:张三

        System.out.println("=====================");

        // 设置暴力反射
        field3.setAccessible(true);

        // 给field3对象对应的属性赋值
        Teacher t3 = new Teacher();
        field3.set(t3,5000);
        // 获取field3对象对应的属性值
        Object o3 = field3.get(t3);
        System.out.println("salary:"+o3);// 5000


    }
}
