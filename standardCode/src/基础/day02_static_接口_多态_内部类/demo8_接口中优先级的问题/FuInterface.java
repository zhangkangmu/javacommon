package 基础.day02_static_接口_多态_内部类.demo8_接口中优先级的问题;

/**
 * @author 彭智林
 * @date 2019/12/16 10:56
 */
public interface FuInterface {

    public default void method(){
        System.out.println("FuInterface 父接口中的method方法...");
    }
}
