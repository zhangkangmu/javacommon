package 基础.day04_综合练习_管理系统.teacher;


import 基础.day04_综合练习_管理系统.superclass.Person;

/**
 * @author 彭智林
 * @date 2019/12/19 9:44
 */
public class Teacher extends Person {

    public Teacher(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    public Teacher() {
    }

    @Override
    public String getType() {
        return "老师";
    }

    @Override
    public String getWork() {
        return "教Java...";
    }
}
