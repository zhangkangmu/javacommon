package 小案例.My学生管理系统.student;


import 小案例.My学生管理系统.utils.StudentManagerUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2019/12/19
 */
public class StudentMain {

    public void main(ArrayList<Student> students, Scanner scanner) throws Exception {
        while (true) {
            System.out.println("【学员信息管理】");
            System.out.println("1.增加学员\t\t2.查询学员\t\t3.修改学员\t\t4.删除学员\t\t5.返回");
            System.out.println("请输入功能序号：");
            String next = scanner.next();
            switch (next) {
                case "1":
                    //1.增加学员
                    StudentManagerUtils.addStudent(students, scanner);
                    break;
                //2.查询学员
                case "2":
                    StudentManagerUtils.checkStudent(students, scanner);
                    break;
                //3.修改学员
                case "3":
                    StudentManagerUtils.modifyStudent(students, scanner);

                    break;
                //4.删除学员
                case "4":
                    StudentManagerUtils.deleteStudent(students, scanner);
                    break;
                //5.返回
                case "5":
                    return;
                default:
                    break;
            }
        }
    }

}
