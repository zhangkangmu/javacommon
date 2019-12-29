package 基础.day01静态_继承_模板设计模式_抽象类_final.demo3_继承的案例;

/**
 * @author 彭智林
 * @date 2019/12/15 10:13
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            经过分析;
                Person类:
                    属性:姓名,年龄
                    行为:吃饭,睡觉
                学生类: 继承Person类
                老师类: 继承Person类
                    属性: 薪水
                    行为: 教书
                班主任类: 继承Person类
                    属性: 薪水
                    行为: 管理
         */
        // 测试学生类
        // 创建学生对象
        Student stu = new Student();
        // 使用学生对象访问属性和方法
        stu.setName("张三");
        stu.setAge(18);
        System.out.println("姓名是:"+stu.getName()+",年龄是:"+stu.getAge());
        stu.sleep();
        stu.eat();
        System.out.println("=============================================");

        // 老师类
        // 创建老师对象
        Teacher t1 = new Teacher(50000.0);
        // 使用老师对象访问属性和方法
        t1.setName("晓慧老师");
        t1.setAge(18);
        System.out.println("姓名是:"+t1.getName()+",年龄是:"+t1.getAge()+",薪水是:"+t1.getSalary());
        t1.sleep();
        t1.eat();
        t1.teach();
        System.out.println("=============================================");

        // 班主任类
        // 创建班主任对象
        BanZhuRen bzr = new BanZhuRen();
        // 使用班主任对象访问属性和方法
        bzr.setName("小芳");
        bzr.setAge(18);
        bzr.setSalary(30000.0);
        System.out.println("姓名是:"+bzr.getName()+",年龄是:"+bzr.getAge()+",薪水是:"+bzr.getSalary());
        bzr.sleep();
        bzr.eat();
        bzr.manage();
        System.out.println("=============================================");


    }
}
