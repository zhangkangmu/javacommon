package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo19_方法引用的分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭智林
 * @date 2020/1/2 17:37
 */
public class Demo {
    /*
        方法引用:
            概述:方法引用就是用来在一定的情况下,替换Lambda表达式
            替换的场景:
                如果一个Lambda表达式大括号中的代码和另一个方法中的代码一模一样,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
                如果一个Lambda表达式大括号中的代码就是调用另一方法,那么就可以使用方法引用把该方法引过来,从而替换Lambda表达式
            方法引用格式: 双冒号  ::
            方法引用的分类:
                第一种方法引用的类型是构造器引用:  类名::new
                第二种方法引用的类型是静态方法引用: 类名::静态方法名
                第三种方法引用的类型是非静态成员方法引用:
                            非静态成员方法没有参数: 类名::非静态方法名
                            非静态成员方法有参数: 对象名::非静态方法名

     */
    public static void main(String[] args) {
        Car car1 = Car.create(()->{return  new Car();});// lambda
        // 上面的Lambda表达式的大括号里面其实就是调用Car类的构造方法
        // 所以上面的Lambda表达式可以使用方法引用来替换
        // 构造方法引用的格式: 类名::new
        Car car2 = Car.create(Car::new);// 方法引用
        System.out.println(car1);
        System.out.println(car2);

        // 把car1和car2添加到一个List集合中
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);

        // 获取list的Stream流,调用forEach方法,在forEach方法中调用method1方法
        list.stream().forEach((Car c)->{Car.method1(c);});
        System.out.println("========================================");
        // 上面的Lambda表达式的大括号里面其实就是调用Car类的静态方法method1
        // 所以上面的Lambda表达式可以使用方法引用来替换
        // 静态方法引用格式: 类名::静态方法名
        list.stream().forEach(Car::method1);

        System.out.println("========================================");
        // 获取list的Stream流,调用forEach方法,在forEach方法中使用流中的car对象调用method2方法,注意method2方法没有参数
        list.stream().forEach((Car c)->{c.method2();});
        System.out.println("========================================");
        // 上面的Lambda表达式的大括号里面其实就是调用Car类的非静态成员方法method2
        // 所以上面的Lambda表达式可以使用方法引用来替换
        // 非静态方法引用格式: 类名::非静态方法名   非静态方法是没有参数的非静态方法
        list.stream().forEach(Car::method2);

        System.out.println("========================================");
        // 获取list的Stream流,调用forEach方法,在forEach方法中使用流中的car对象调用method3方法,注意method3方法有参数
        list.stream().forEach((Car car)->{car.method3(car);});
        // 上面的Lambda表达式的大括号里面其实就是调用Car类的非静态成员方法method3
        // 所以上面的Lambda表达式可以使用方法引用来替换
        // 非静态方法引用格式: 对象名::非静态方法名   非静态方法是有参数的非静态方法
        list.stream().forEach(car1::method3);

    }

}
