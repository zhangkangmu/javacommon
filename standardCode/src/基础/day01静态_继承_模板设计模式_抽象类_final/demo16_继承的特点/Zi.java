package 基础.day01静态_继承_模板设计模式_抽象类_final.demo16_继承的特点;

/**
 * @author 彭智林
 * @date 2017/12/15 12:28
 */
public class Zi extends Fu {

    public void show(){
        System.out.println(num1);// 能访问,说明已经继承过来
        System.out.println(num2);
    }
}
