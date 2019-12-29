package 基础.day01静态_继承_模板设计模式_抽象类_final.demo6_继承后父子类成员变量不重名;

/**
 * @author 彭智林
 * @date 2019/12/15 11:00
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            继承后父子类成员变量不重名:不影响使用,正常访问即可
         */
        // 创建Zi类对象
        Zi zi = new Zi();
        // 调用Zi类对象的show方法
        zi.show();
    }
}
