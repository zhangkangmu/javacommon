package 基础.day01静态_继承_模板设计模式_抽象类_final.demo8_super访问父类继承过来的成员变量;

/**
 * @author 彭智林
 * @date 2019/12/15 11:10
 */
public class Demo {
    public static void main(String[] args) {
        /*
            super访问父类继承过来的成员变量:使用super关键字
                格式:
                    super.父类成员变量名

         */
        // 创建Zi类对象
        Zi zi = new Zi();
        // 使用Zi类对象调用show方法
        zi.show();
    }
}
