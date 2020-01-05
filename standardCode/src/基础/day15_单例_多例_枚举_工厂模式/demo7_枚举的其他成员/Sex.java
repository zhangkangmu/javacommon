package 基础.day15_单例_多例_枚举_工厂模式.demo7_枚举的其他成员;

/**
 * @author 彭智林
 * @date 2020/1/5 10:10
 */
public enum Sex {// 完整
    // 枚举值,注意这个一定要放在第一行
    BOY("BOY"),GIRL("GIRL");

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
}
