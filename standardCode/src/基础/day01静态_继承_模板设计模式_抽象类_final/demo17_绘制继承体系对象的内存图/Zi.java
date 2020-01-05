package 基础.day01静态_继承_模板设计模式_抽象类_final.demo17_绘制继承体系对象的内存图;

/**
 * @author 彭智林
 * @date 2017/12/15 14:37
 */
public class Zi extends Fu {
    // 成员变量
    int num = 20;

    int numZi = 200;

    // 成员方法
    public void methodZi(){
        System.out.println("methodZi...");
    }

    @Override
    public void method(){
        System.out.println("Zi method...");
    }

    public void show(){
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
