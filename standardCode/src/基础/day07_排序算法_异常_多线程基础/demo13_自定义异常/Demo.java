package 基础.day07_排序算法_异常_多线程基础.demo13_自定义异常;

import java.util.Scanner;

/**
 * @author 彭智林
 * @date 2017/12/24 14:40
 */
public class Demo {
    // 数据库,存储的是已经注册过的用户名
    static String[] names = {"jack", "rose", "lily", "lucy", "liLei", "jim"};

    public static void main(String[] args) {
        /*
            自定义异常:
                1. 自定义一个编译期异常: 自定义类 并继承于java.lang.Exception。
                2. 自定义一个运行时期的异常类:自定义类 并继承于java.lang.RuntimeException。
            练习:
                要求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。
                分析:
                    1.抛出的异常,注册异常,SUN公司并没有定义注册异常,所以需要我们自定义注册异常类(运行异常)
         */
        // 1.创建Scanner对象,用来键盘录入
        Scanner sc = new Scanner(System.in);

        // 2.获取键盘录入的用户名
        System.out.println("请输入用户名:");
        String username = sc.next();

        // 3.判断该用户名是否已经被注册了
        boolean flag = false;// 旗帜变量   开关变量

        for (String name : names) {
            if (name.equals(username)) {
               flag = true;
            }
        }

        if(flag == true){
            try {
                // 4.如果已经被注册,就产生了注册异常,创建注册异常对象,并使用throw关键字抛出
                throw new RegisterException("亲，该用户名已经被注册。");
            } catch (RegisterException e) {
                System.out.println(e.getMessage());
            }
        }else{
            // 5.如果没有被注册,就输出注册成功
            System.out.println("恭喜您,注册成功!");

        }
    }
}
