package 基础.day15_单例_多例_枚举_工厂模式.demo5_多例模式的应用;

/**
 * @author 彭智林
 * @date 2018/1/5 9:53
 */
public class Sex {

    // 创建Sex类的对象
    public static final Sex BOY = new Sex("boy");
    public static final Sex GIRL = new Sex("girl");

    private String title;

    // 将构造方法私有化
    private Sex(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return title;
    }
}
