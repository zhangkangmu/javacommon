package 基础.day03_权限修饰符_代码块_常用API.demo6_toString方法;

/**
 * @author 彭智林
 * @date 2019/12/18 9:36
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Object类的toString方法:
                 public String toString()：返回该对象的字符串表示。

                 toString方法默认返回的字符串内容格式为: 包的全路径.类名+@+地址值
                 打印对象的时候,其实打印的是该对象调用toString方法返回的字符串内容
                 所以,如果希望打印对象的时候不是打印对象的地址值,那么就应该重写toString方法

            结论:
                1.toString方法默认返回的字符串内容格式为: 包的全路径.类名+@+地址值
                2.打印对象的时候,其实打印的是该对象调用toString方法返回的字符串内容
                3.如果开发中,打印对象不希望打印地址值,那么就应该重写toString方法
                4.如果以后打印一个对象,打印的不是地址值,那么该对象所属的类一定重写了toString方法
         */
        // 创建Person类的对象
        Person p = new Person("张三",19);
        // 使用Person类的对象调用toString()方法
        String pStr = p.toString();
        System.out.println("p对象调用toString方法返回的字符串内容:"+pStr);
        System.out.println("p对象:"+p);// 说明打印对象的时候,其实打印的是该对象调用toString方法返回的字符串内容

        System.out.println("============================================================");
        Object obj = new Object();
        String objStr = obj.toString();
        System.out.println("obj对象调用toString方法返回的字符串内容:"+objStr);
        System.out.println("obj对象:"+obj);
    }
}
