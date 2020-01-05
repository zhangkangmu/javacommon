package 小案例.My学生管理系统.teacher;


import 小案例.My学生管理系统.utils.TeacherManagerUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2017/12/19
 */
public class TeacherMain {

    public void main(ArrayList<Teacher> teachers, Scanner scanner) throws Exception {
        while (true) {
            System.out.println("【老师管理系统】");
            System.out.println("1.增加老师\t\t2.查询老师\t\t3.修改老师\t\t4.删除老师\t\t5.返回");
            System.out.println("请输入功能序号：");
            String next = scanner.next();
            switch (next) {
                case "1":
                    //1.增加老师
                    TeacherManagerUtils.addTeacher(teachers,scanner);
                    break;
                case "2":
                    //2.查询老师
                    TeacherManagerUtils.checkTeacher(teachers,scanner);
                    break;
                case "3":
                    //3.修改老师
                    TeacherManagerUtils.modifyStudent(teachers,scanner);
                    break;
                case "4":
                    //4.删除老师
                    TeacherManagerUtils.deleteStudent(teachers,scanner);
                    break;
                case "5":
                    //5.返回
                    return;
                default:
                    break;
            }
        }
    }
}
