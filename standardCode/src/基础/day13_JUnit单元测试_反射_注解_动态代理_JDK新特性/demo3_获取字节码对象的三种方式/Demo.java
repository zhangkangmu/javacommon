package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo3_获取字节码对象的三种方式;

/**
 * @author 彭智林
 * @date 2018/1/2 9:50
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        /*
            Class类: 表示字节码对象的类,任意一个类都有字节码对象(类型都是Class)

            获取字节码对象的三种方式:
                通过类名直接获取: 类名.class
                通过Class类的方法获取:  public static Class forName(类的全路径); 类的全路径:包名+类名   推荐
                通过类的对象获取: public Class getClass();  注意:getClass方法属于Object类

            注意:一个类只有一个Class对象
         */
        // 通过类名直接获取: 类名.class
        Class clazz1 = Student.class;// 表示Student类的Class对象
        Class clazz2 = Demo.class;// 表示Demo类的Class对象

        // 通过Class类的方法获取:  public static Class forName(类的全路径)
        Class clazz3 = Class.forName("com.itheima.demo3_获取字节码对象的三种方式.Student");// 表示Student类的Class对象

        // 通过类的对象获取: public Class getClass();
        Student stu = new Student();
        Class clazz4 = stu.getClass();// 表示Student类的Class对象

        System.out.println(clazz1);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz3);// true
        System.out.println(clazz3 == clazz4);// true
        System.out.println(clazz1 == clazz4);// true


    }
}
