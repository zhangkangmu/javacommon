package hong.练习的包.day11_io加强.装饰者模式;

/**
 * Created by zhangyuhong
 * Date:2019/12/30
 */
public class Liu implements Start {
    @Override
    public void play() {
        System.out.println("开始玩、、、");
    }

    @Override
    public void dance() {
        System.out.println("开始跳舞、、、");
    }
}
