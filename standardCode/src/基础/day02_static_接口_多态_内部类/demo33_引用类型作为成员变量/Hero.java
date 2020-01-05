package 基础.day02_static_接口_多态_内部类.demo33_引用类型作为成员变量;

/**
 * @author 彭智林
 * @date 2017/12/16 16:49
 */
public class Hero {
    /**
     * 名称
     */
    public String name;// 引用类型作为成员变量 String--->类--->引用数据类型
    /**
     * 武器
     */
    public Weapon wp;// Weapon--->类--->引用数据类型
    /**
     * 法术
     */
    public FaShu fashu;// FaShu--->接口--->引用数据类型

    public Hero(String name, Weapon wp, FaShu fashu) {
        this.name = name;
        this.wp = wp;
        this.fashu = fashu;
    }

    public void show(){
        System.out.println("我的武器是:"+wp.name);
        System.out.println("我的法术是:"+fashu.name);
    }
}
