package hong.练习的包.day11_io加强.装饰者模式;

/**
 * Created by zhangyuhong
 * Date:2017/12/30
 */
public class LiuPlus implements Start{
    private Liu liu;

    public LiuPlus(Liu liu) {
        this.liu=liu;
    }

    @Override
    public void play() {
        System.out.println("allalalalalalal");
    }

    @Override
    public void dance() {
        liu.play();
    }
}
