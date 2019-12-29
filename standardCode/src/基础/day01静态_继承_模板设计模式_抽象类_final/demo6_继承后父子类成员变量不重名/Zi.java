package 基础.day01静态_继承_模板设计模式_抽象类_final.demo6_继承后父子类成员变量不重名;

/**
 * @author 彭智林
 * @date 2019/12/15 11:00
 */
public class Zi extends Fu{

    int numZi = 20;

    public void show(){
        System.out.println("numFu :"+numFu);// 从父类继承过来的
        System.out.println("numZi :"+numZi);// 子类独有的
    }

}
