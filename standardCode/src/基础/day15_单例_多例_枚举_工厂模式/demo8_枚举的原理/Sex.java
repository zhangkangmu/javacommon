package 基础.day15_单例_多例_枚举_工厂模式.demo8_枚举的原理;

import java.util.Enumeration;

/**
 * @author 彭智林
 * @date 2020/1/5 10:18
 */
public class Sex implements Enumeration<Sex> {
    // Sex类的对象
    public static final Sex BOY = new Sex("BOY");
    public static final Sex GIRL = new Sex("GIRL");

    // 成员变量
    private String title;

    // 构造方法
    private Sex(String title){
        this.title = title;
    }

    // 成员方法
    @Override
    public String toString() {
        return title;
    }


    @Override
    public boolean hasMoreElements() {
        return false;
    }

    @Override
    public Sex nextElement() {
        return null;
    }
}
