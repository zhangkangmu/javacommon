package 基础.day01静态_继承_模板设计模式_抽象类_final.demo11_方法重写;

/**
 * @author 彭智林
 * @date 2017/12/15 11:26
 */
public class Zi extends Fu {

    // 子类中的功能完全覆盖父类的功能
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("第"+(i+1)+"圈");
        }
    }

    // 子类要延续父类的功能,但是要在父类实现的功能基础上额外增加一点点功能
    @Override
    public void method(){
       // 让父类的method方法执行一下即可
        super.method();

        for (int i = 0; i < 20; i++) {
            System.out.println("Hello World"+i);
        }
    }

    public void method2(){

    }
}
