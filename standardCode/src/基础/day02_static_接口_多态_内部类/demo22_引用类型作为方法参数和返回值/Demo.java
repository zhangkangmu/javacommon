package 基础.day02_static_接口_多态_内部类.demo22_引用类型作为方法参数和返回值;

/**
 * @author 彭智林
 * @date 2019/12/16 16:23
 */
public class Demo {
    public static void main(String[] args) {
        /*
            引用类型作为方法参数和返回值:
                引用类型作为方法的参数和返回值传递的是地址值
                基本数据类型作为方法的参数和返回值传递的是具体的值
         */
        // 调用getPerson方法,传入一个Person对象
        Person p = new Person("张三", 28);
        Person p2 = getPerson(p);
        System.out.println(p == p2);//   true
        p.show();// 姓名是:张三,年龄是:120
        p2.show();// 姓名是:张三,年龄是:120
    }

    public static Person getPerson(Person p){
        // 修改传入的Person对象的年龄为120岁,并把该对象返回
        p.age = 120;
        return p;
    }
}
