package 基础.day01静态_继承_模板设计模式_抽象类_final.demo14_super关键字的三种方式;

/**
 * @author 彭智林
 * @date 2019/12/15 12:09
 */
public class Zi extends Fu {

    /*
        错误原因:
            1.Zi类中没有定义构造方法,会自动生成一个空参构造方法
            2.Zi类继承Fu类,子类的构造方法默认会调用父类的空参构造方法
            3.现在是Fu类没有空参构造方法,所以子类中自动生成的空参构造
              方法里面调用父类的空参构造方法失败,所以编译报错
     */
    public Zi(int numFu){
        super(numFu);// 访问父类的构造方法
    }

    public void method(){
        System.out.println(super.numFu);// 访问父类的成员变量
        super.show();// 访问父类的成员方法
    }
}
