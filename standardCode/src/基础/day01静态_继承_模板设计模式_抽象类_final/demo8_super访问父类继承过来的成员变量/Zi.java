package 基础.day01静态_继承_模板设计模式_抽象类_final.demo8_super访问父类继承过来的成员变量;

/**
 * @author 彭智林
 * @date 2017/12/15 11:06
 */
public class Zi extends Fu {
    int num = 20;

    public void show(){
        int num = 30;
        System.out.println("访问父类继承过来的 num:"+super.num);// 10
        System.out.println("访问本类成员变量 num:"+this.num);// 20
        System.out.println("访问show方法中的局部变量 num:"+num);// 30
    }
}
