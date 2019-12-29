package 基础.day02_static_接口_多态_内部类.demo10_抽象类和接口的练习;

/**
 * @author 彭智林
 * @date 2019/12/16 11:20
 */
public class JiDuQuan extends Quan implements JiDuInterface {
    @Override
    public void jiDu() {
        System.out.println("缉毒犬在缉毒...");
    }

    @Override
    public void houJiao() {
        System.out.println("缉毒犬在旺旺叫...");
    }

    @Override
    public void eat() {
        System.out.println("缉毒犬吃骨头...");
    }
}
