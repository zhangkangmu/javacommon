package 基础.day01静态_继承_模板设计模式_抽象类_final.demo15_this关键字的三种用法;

/**
 * @author 彭智林
 * @date 2017/12/15 12:15
 */
public class Demo {
    public static void main(String[] args) {
        /*
            this关键字的三种用法:
                this:存储的“当前对象”的引用；
                this访问本类的构造方法:
                        空参构造: this();
                        有参构造: this(实参);

                this访问本类的成员方法:
                        this.本类方法名();

                this访问本类的成员变量:  重点掌握
                        this.本类成员变量名

                注意:
                    1.本类的构造方法不能相互调用
                    2.在本类的构造方法中调用本类的构造方法一定要放在第一行,否则会编译失败
         */
        /*// 调用Person类的空参构造方法
        Person p1 = new Person();*/

        // 调用Person类的有参构造方法
        Person p1 = new Person(18);
        p1.eat();

    }
}
