package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo6_通过反射获取一个类的方法;

/**
 * @author 彭智林
 * @date 2018/1/2 11:11
 */
public class Zi extends Fu {

    public void test1(){
        System.out.println("test1...");
    }

    public void test2(int num){
        System.out.println("test2..."+num);
    }

    private void test3(){
        System.out.println("test3...");
    }

    public static void test4(String str){
        System.out.println("test4..."+str);
    }

    private static void test5(String str){
        System.out.println("test5..."+str);
    }

}
