package 基础.day01静态_继承_模板设计模式_抽象类_final.demo5_子类不能继承的内容;


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

    public Teacher(String name,int age,double salary){
        // 给从父类继承过来的属性赋值
        super(name,age);//调用父类的构造方法
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
