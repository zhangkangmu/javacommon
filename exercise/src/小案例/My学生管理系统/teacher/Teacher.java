package 小案例.My学生管理系统.teacher;


import 小案例.My学生管理系统.superclass.Person;

/**
 * Created by zhangyuhong
 * Date:2019/12/19
 */
public class Teacher extends Person {
    @Override
    public String identity() {
        return "老师";
    }

    @Override
    public String workType() {
        return "教导学生学习java...";
    }
}
