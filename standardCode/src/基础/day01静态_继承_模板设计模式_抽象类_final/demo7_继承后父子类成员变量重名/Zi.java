package 基础.day01静态_继承_模板设计模式_抽象类_final.demo7_继承后父子类成员变量重名;

/**
 * @author 彭智林
 * @date 2017/12/15 11:06
 */
public class Zi extends Fu {
    int num = 20;

    public void show(){
        int num = 30;
        System.out.println("访问父类继承过来的 num:"+num);
        System.out.println("访问本类的 num:"+num);
    }
}
