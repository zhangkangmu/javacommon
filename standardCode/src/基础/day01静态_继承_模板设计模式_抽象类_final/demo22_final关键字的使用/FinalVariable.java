package 基础.day01静态_继承_模板设计模式_抽象类_final.demo22_final关键字的使用;

/**
 * @author 彭智林
 * @date 2019/12/15 16:41
 */
public class FinalVariable {

    final int NUM1 = 10;

    final int NUM2;

    public FinalVariable(int NUM2){
        this.NUM2 = NUM2;
    }

    public FinalVariable(){
        this.NUM2 = 10;
    }

}
