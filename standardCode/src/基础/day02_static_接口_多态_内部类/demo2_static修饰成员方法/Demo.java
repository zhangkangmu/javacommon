package 基础.day02_static_接口_多态_内部类.demo2_static修饰成员方法;

/**
 * @author 彭智林
 * @date 2019/12/16 9:06
 */
public class Demo {
    public static void main(String[] args) {
        /*
            static修饰成员方法:
                概述:被static修饰的方法会变成静态方法,也称为类方法,该静态方法可以使用类名直接调用
                格式:
                    修饰符  static 返回值类型 方法名(形参列表){

                    }

                访问方式:
                    对象名.方法名(实参);
                    类名.方法名(实参);   推荐

               注意事项:
                    1.静态方法中不能出现this关键字
                    2.静态方法中只能直接访问静态成员变量和静态成员方法
                    3.静态方法中不能直接访问非静态成员变量和非静态成员方法
                    4.非静态方法中可以直接访问一切成员变量和成员方法
         */
        People.method();

        // 创建People对象
        People p = new People();
        p.method();

    }

}
