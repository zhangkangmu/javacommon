package 基础.day01静态_继承_模板设计模式_抽象类_final.demo2_继承的格式;

/**
 * @author 彭智林
 * @date 2019/12/15 9:59
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            - 继承：就是子类继承父类的属性和方法，使得子类对象可以直接具有与父类相同的属性、相同的方法。
            - 继承的好处:
              - 提高代码的复用性
              - 让类与类之间产生关系
              - 是实现多态的前提条件之一

            继承的格式:
                public class 类A extends 类B{

                }

                类A 就是子类名
                类B 就是父类名
         */
        // 创建Student对象
        Student stu = new Student();

        // 给Student对象的name和age赋值
        stu.setName("张无忌");
        stu.setAge(18);

        // 取出Student对象的name和age的值
        System.out.println("姓名是:"+stu.getName()+",年龄是:"+stu.getAge());

        // 使用Student对象调用sleep()和eat()方法
        stu.sleep();
        stu.eat();


    }
}
