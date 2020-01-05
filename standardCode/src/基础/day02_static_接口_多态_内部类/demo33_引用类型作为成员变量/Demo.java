package 基础.day02_static_接口_多态_内部类.demo33_引用类型作为成员变量;

/**
 * @author 彭智林
 * @date 2017/12/16 16:49
 */
public class Demo {
    public static void main(String[] args) {
        // 创建武器
        Weapon wp = new Weapon("大宝剑");

        // 创建法术
        FaShu faShu = new FaShu() {
        };

        // 创建英雄
        Hero hero = new Hero("盖伦",wp,faShu);
        hero.show();
    }
}
