package 基础.day02_static_接口_多态_内部类.demo1_static关键字修饰成员变量;

/**
 * @author 彭智林
 * @date 2017/12/16 8:50
 */
public class Demo {
    public static void main(String[] args) {
        /*
            static 关键字:
                概述:static是静态修饰符，表示静态的意思,可以修饰成员变量和成员方法以及代码块。
                static关键字修饰成员变量:
                    当 static 修饰成员变量时，该变量称为类变量(静态成员变量)。
                    该类的每个对象都共享同一个类变量的值。
                    任何对象都可以更改该类变量的值，但也可以在不创建该类的对象的情况下对类变量进行操作。

                    格式:
                        static 数据类型 变量名;

                静态成员变量的访问方式:
                        对象名.静态成员变量名
                        类名.静态成员变量名
         */
        // 使用类名直接访问country
        ChinesePeople.country = "中国";

        // 创建ChinesePeople类的对象,并给属性赋值
        ChinesePeople p1 = new ChinesePeople();
        p1.name = "张三";
        p1.age = 18;
       //  p1.country = "中国";
        // 打印所有属性的值
        System.out.println("姓名是:"+p1.name+",年龄是:"+p1.age+",国籍是:"+p1.country);

        // 创建ChinesePeople类的对象,并给属性赋值
        ChinesePeople p2 = new ChinesePeople();
        p2.name = "李四";
        p2.age = 19;
       //  p2.country="英国";
        // 打印所有属性的值
        System.out.println("姓名是:"+p2.name+",年龄是:"+p2.age+",国籍是:"+p2.country);


        System.out.println(new ChinesePeople().country);

    }
}
