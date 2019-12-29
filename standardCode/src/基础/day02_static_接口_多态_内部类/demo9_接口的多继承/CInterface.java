package 基础.day02_static_接口_多态_内部类.demo9_接口的多继承;

/**
 * @author 彭智林
 * @date 2019/12/16 11:00
 */
public interface CInterface extends AInterface,BInterface{
    @Override
    default void show() {
        System.out.println("重写默认方法show...");
    }
}
