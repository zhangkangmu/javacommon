package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo17_动态代理;

/**
 * @author 彭智林
 * @date 2020/1/2 16:38
 */
public class JinLian implements FindHappy {
    @Override
    public void happy(int age) {
        System.out.println("金莲在happy..."+"---"+age);
    }
}
