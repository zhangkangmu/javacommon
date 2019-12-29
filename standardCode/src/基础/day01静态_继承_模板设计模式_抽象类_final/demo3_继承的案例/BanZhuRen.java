package 基础.day01静态_继承_模板设计模式_抽象类_final.demo3_继承的案例;

/**
 * @author 彭智林
 * @date 2019/12/15 10:17
 */
public class BanZhuRen extends Person{
    /**
     * 薪水
     */
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 管理
     */
    public void manage(){
        System.out.println("班主任正在管理班级纪律...");
    }
}
