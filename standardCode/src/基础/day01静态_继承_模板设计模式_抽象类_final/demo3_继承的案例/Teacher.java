package 基础.day01静态_继承_模板设计模式_抽象类_final.demo3_继承的案例;

/**
 * @author 彭智林
 * @date 2019/12/15 10:15
 */
public class Teacher extends Person {
    /**
     * 薪水
     */
    private double salary;

    public Teacher(){

    }

    public Teacher(double salary){
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 成员方法

    /**
     * 教书
     */
    public void teach(){
        System.out.println("老师正在教技术...");
    }
}
