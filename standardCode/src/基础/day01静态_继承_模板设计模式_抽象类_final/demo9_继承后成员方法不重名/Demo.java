package 基础.day01静态_继承_模板设计模式_抽象类_final.demo9_继承后成员方法不重名;

/**
 * @author 彭智林
 * @date 2017/12/15 11:14
 */
public class Demo {
    public static void main(String[] args) {
        /*
            继承后成员方法不重名访问规则:不影响,正常访问即可
         */
        // 创建Zi类对象
        Zi zi = new Zi();
        // 使用Zi类对象调用methodZi()方法
        zi.methodZi();
        // 使用Zi类对象调用methodFu()方法
        zi.methodFu();
    }
}
