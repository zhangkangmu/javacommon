package 基础.day01静态_继承_模板设计模式_抽象类_final.demo13_继承构造方法访问规则;

/**
 * @author 彭智林
 * @date 2019/12/15 11:51
 */
public class Demo {
    public static void main(String[] args) {
        /*
            继承构造方法访问规则:
                1.子类是无法继承父类构造方法的。
                2.子类的构造方法中可以通过super(实参)来访问父类的构造方法,从而给从父类继承过来的属性初始化

             注意事项:
                1.子类的构造方法默认会调用父类的空参构造方法
                2.子类的构造方法中调用父类的构造方法一定要放在第一行,否则会编译失败
                3.子类调用父类的构造方法只能在子类的构造方法中
                4.如果子类的构造方法中手动调用了父类的构造方法,那么就不会自动调用父类的空参构造方法

         */
        // 创建Student对象
        Student stu = new Student("jack",3,99);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getScore());
    }
}
