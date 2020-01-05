package 基础.day02_static_接口_多态_内部类.demo10_抽象类和接口的练习;

/**
 * @author 彭智林
 * @date 2017/12/16 11:19
 */
public class Demo {
    public static void main(String[] args) {
        // 创建缉毒犬对象
        JiDuQuan jiDuQuan = new JiDuQuan();
        // 使用缉毒犬对象调用方法
        jiDuQuan.eat();
        jiDuQuan.houJiao();
        jiDuQuan.jiDu();
    }
}
