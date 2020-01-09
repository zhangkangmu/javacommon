package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo16_代理模式;

/**
 * @author 彭智林
 * @date 2018/1/2 16:39
 */
public class WangPo implements FindHappy {

    JinLian jinLian;

    public WangPo(JinLian jinLian) {
        this.jinLian = jinLian;
    }

    @Override
    public void happy() {
        System.out.println("王婆以做头发的名义把房间开好了...");
        // 金莲happy()
        jinLian.happy();
        System.out.println("happy完后,王婆打扫战场...");

    }
}
