package hong.练习的包.day11_io加强.装饰者模式;

/**
 * Created by zhangyuhong
 * Date:2019/12/30
 */
public class Demo {
    public static void main(String[] args) {
        LiuPlus liuPlus = new LiuPlus(new Liu());
        liuPlus.dance();
        liuPlus.play();
    }
}
