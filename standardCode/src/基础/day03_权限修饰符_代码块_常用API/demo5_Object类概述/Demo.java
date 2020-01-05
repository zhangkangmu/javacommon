package 基础.day03_权限修饰符_代码块_常用API.demo5_Object类概述;

/**
 * @author 彭智林
 * @date 2017/12/18 9:19
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Object类概述:
                概述:java.lang.Object类是Java语言中的根类，即所有类的父类.
                    也就是说java中所有的类都是直接或者间接继承Object类
                    直接继承Object类:
                        例如: public class Person /*省略 extends Object * /{

                             }

                    间接继承Object类:
                        例如: public class Student extends Person{

                             }
              特点: Object类中所有的方法都可以被java中任意类访问   原因: Object类是所有类的父类
              Object类当中包含的方法有11个。今天我们主要学习其中的2个：
                    - public String toString()：返回该对象的字符串表示。
                    - public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。

         */

    }
}
