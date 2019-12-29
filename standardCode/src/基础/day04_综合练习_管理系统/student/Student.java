package 基础.day04_综合练习_管理系统.student;


import 基础.day04_综合练习_管理系统.superclass.Person;

/**
 * @author 彭智林
 * @date 2019/12/19 9:43
 */
public class Student extends Person {

    public Student(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    public Student() {
    }

    @Override
    public String getType() {
        return "学生";
    }

    @Override
    public String getWork() {
        return "学习Java...";
    }
}
