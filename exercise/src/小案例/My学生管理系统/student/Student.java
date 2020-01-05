package 小案例.My学生管理系统.student;

import 小案例.My学生管理系统.superclass.Person;

/**
 * Created by zhangyuhong
 * Date:2017/12/19
 */
public class Student extends Person {
    @Override
    public String identity() {
        return "学生";
    }

    @Override
    public String workType() {
        return "学习java...";
    }
}
