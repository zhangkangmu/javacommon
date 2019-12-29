package 小案例.My学生管理系统;


import 小案例.My学生管理系统.student.Student;
import 小案例.My学生管理系统.student.StudentMain;
import 小案例.My学生管理系统.teacher.Teacher;
import 小案例.My学生管理系统.teacher.TeacherMain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2019/12/19
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        beginChoose(scanner);
    }

    private static void beginChoose(Scanner scanner) throws Exception {
        StudentMain studentManager=new StudentMain();
        TeacherMain teacherManager=new TeacherMain();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (true) {
            System.out.println("1.学员管理系统   2.教师管理系统    3.退出系统");
            String next = scanner.next();
            switch (next) {
                case "1":
                    //进入学员管理系统理系统
                    studentManager.main(students,scanner);
                    break;
                case "2":
                    //进入教师管理系统理系统
                    teacherManager.main(teachers,scanner);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
