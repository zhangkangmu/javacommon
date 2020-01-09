package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo16_代理模式;

/**
 * @author 彭智林
 * @date 2018/1/2 16:38
 */
public class JinLian implements FindHappy {
    @Override
    public void happy() {
        System.out.println("金莲在happy...");
    }
}
