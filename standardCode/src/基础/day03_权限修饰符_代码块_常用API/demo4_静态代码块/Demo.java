package 基础.day03_权限修饰符_代码块_常用API.demo4_静态代码块;

/**
 * @author 彭智林
 * @date 2017/12/18 9:12
 */
public class Demo {
    public static void main(String[] args) {
        /*
            局部代码块: 方法中的代码块{}
            静态代码块:
                概述:定义在成员位置，使用static修饰的代码块{ }。
                格式:
                    public class 类名{
                        static {

                        }
                    }
                执行:随着类的加载而执行,并且只执行一次,优先构造方法执行
         */
        new Person();
        new Person();

    }
}
