package 基础.day01静态_继承_模板设计模式_抽象类_final.demo12_方法重写的注意事项;

/**
 * @author 彭智林
 * @date 2017/12/15 11:45
 */
public class Demo {
    public static void main(String[] args) {
        /*
            方法重写的注意事项:
                1. 方法重写是发生在父子类之间的关系。
                2. 子类方法覆盖父类方法，返回值类型、方法名和参数列表都要一模一样。
                3. 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
                     权限修饰符的大小: private  < 默认(default) < protected < public
                4. 私有方法不能被重写
         */
    }
}
