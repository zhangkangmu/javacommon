package 基础.day01静态_继承_模板设计模式_抽象类_final.demo5_子类不能继承的内容;

/**
 * @author 彭智林
 * @date 2019/12/15 10:43
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            子类不能继承的内容:
                1.子类无法继承父类的构造方法,但是可以通过调用父类的构造方法给从父类继承过来的属性初始化
                   也就是说:通过调用父类的构造方法,初始化从父类继承过来的属性
                   调用父类的空参构造方法: super();
                   调用父类的有参构造方法: super(实参);

                2.是子类可以继承父类的私有成员（成员变量，方法），
                    只是子类无法直接访问而已，可以通过getter/setter方法访问父类的private成员变量。

                注意事项:
                    1.子类的构造方法中默认会调用父类的空参构造方法
                    2.子类构造方法中调用父类的构造方法,必须放在第一行,否则编译失败
         */
        // 创建Teacher类的对象
        Teacher t1 = new Teacher();// 空参构造方法
        Teacher t2 = new Teacher(3000.0);// 有参构造方法
        Teacher t3 = new Teacher("小红老师",18,3000.0);// 有参构造方法


        // 访问t1对象的属性
        System.out.println("姓名是:"+t1.getName()+",年龄是:"+t1.getAge()+",薪水是:"+t1.getSalary());

        // 访问t2对象的属性
        System.out.println("姓名是:"+t2.getName()+",年龄是:"+t2.getAge()+",薪水是:"+t2.getSalary());

        // 访问t3对象的属性
        System.out.println("姓名是:"+t3.getName()+",年龄是:"+t3.getAge()+",薪水是:"+t3.getSalary());
    }
}
