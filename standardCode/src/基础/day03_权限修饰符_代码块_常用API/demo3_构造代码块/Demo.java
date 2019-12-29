package 基础.day03_权限修饰符_代码块_常用API.demo3_构造代码块;

/**
 * @author 彭智林
 * @date 2019/12/18 9:07
 */
public class Demo {
    public static void main(String[] args) {
        /*
            构造代码块:
                概述:定义在成员位置的代码块{}
                格式:
                    public class 类名{
                        {
                            构造代码块
                        }
                    }
                执行:每次创建对象都会执行构造代码块,优先构造方法执行
         */
        new Person();
        new Person();

    }
}
