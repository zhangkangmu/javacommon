package 基础.day01静态_继承_模板设计模式_抽象类_final.demo22_final关键字的使用;

/**
 * @author 彭智林
 * @date 2019/12/15 16:20
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            final：  不可改变。可以用于修饰类、方法和变量。
                - 类：被修饰的类，不能被继承。
                - 方法：被修饰的方法，不能被重写。
                - 变量：被修饰的变量，不能被重新赋值。
            final关键字修饰类:
                格式:  public final class 类名{

                       }
                特点: 被final修饰的类，不能被继承。

           final关键字修饰方法:
                格式:  修饰符 final 返回值类型 方法名(形参列表){

                       }
                特点: 被final修饰的方法，不能被重写。

           final关键字修饰变量:
                局部变量:
                    格式:
                        final 数据类型 变量名 = 值;

                        final 数据类型 变量名;
                        变量名 = 值;

                    特点: 被final修饰的局部变量,只能赋值一次,不能重复赋值

                成员变量:
                    格式:
                          final 数据类型 变量名 = 值;  推荐

                          final 数据类型 变量名;       不推荐,忽略
                          通过构造方法初始化成员变量

                注意:
                    1.final修饰的变量(包括成员变量和局部变量),都会变成一个常量
                    2.常量名的规范:所有字母大写
         */
        // 定义一个局部变量num
        int num = 10;
        num = 20;
        System.out.println(num);// 20  该num是一个变量,所以可以重复赋值

        System.out.println("====================");
        // 定义一个final修饰的局部变量NUM1
        final int NUM1 = 100;
        // NUM1 = 200; // 错误的原因,因为NUM1被final修饰,只能赋值一次,不能重复赋值
        System.out.println(NUM1);// 100

        System.out.println("====================================");
        // 定义一个final修饰的局部变量NUM2
        final int NUM2;
        NUM2 = 1000;// 这是第一次给NUM2赋值
        // num2 = 2000;// 错误的原因,因为NUM2被final修饰,只能赋值一次,不能重复赋值
        System.out.println(NUM2);// 1000

        System.out.println("==============================================");
        // 访问FinalVariable类中的成员变量NUM1
        FinalVariable fv = new FinalVariable();
        // fv.NUM1 = 20;// 错误的原因,因为NUM1被final修饰,只能赋值一次,不能重复赋值

        FinalVariable fv2 = new FinalVariable(30);


    }
}
