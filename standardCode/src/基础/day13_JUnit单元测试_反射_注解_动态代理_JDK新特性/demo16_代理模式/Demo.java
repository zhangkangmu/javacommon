package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo16_代理模式;

/**
 * @author 彭智林
 * @date 2020/1/2 16:37
 */
public class Demo {
    public static void main(String[] args) {

        JinLian jl = new JinLian();// 被代理对象
        FindHappy proxy = new WangPo(jl); // 代理对象
        proxy.happy();

    }
}
