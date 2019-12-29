package 小案例.My学生管理系统.utils;

import 小案例.My学生管理系统.student.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2019/12/19
 */
public class StudentManagerUtils {


    /**
     * 增加学生到学生管理系统的方法
     *
     * @param students
     * @param scanner
     */
    public static void addStudent(ArrayList<Student> students, Scanner scanner) throws Exception {

        Student student = new Student();
        student.setId(++Utils.sId);
        System.out.println("请输入学生姓名");
        student.setName(scanner.next());
        System.out.println("请输入学生性别");
        student.setSex(scanner.next());
        System.out.println("请输入学生出生日期（格式：xxxx-xx-xx）");
        student.setBirthday(scanner.next());
//        student.setAge(StudentManagerUtils.calculateAge(student.getBirthday()));
        students.add(student);
        System.out.println("增加学生完成！");
        System.out.println("***********************************************************************");
    }

    /**
     * 修改学生信息
     */
    public static void modifyStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("请输入修改的学生id");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (id == student.getId()) {
                System.out.println("请输入学生姓名");
                student.setName(scanner.next());
                System.out.println("请输入学生性别");
                student.setSex(scanner.next());
                System.out.println("请输入学生出生日期（格式：xxxx-xx-xx）");
                student.setBirthday(scanner.next());
                System.out.println("修改学生完成！");
                System.out.println("***********************************************************************");
                return;
            }
        }
        System.out.println("查无此学生！");
    }


    public static void deleteStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("请输入要删除的学生id");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (id == student.getId()) {
                students.remove(student);
                return;
            }
        }
        System.out.println("查无此学生！");
    }




    /**
     * 查询学生功能
     *
     * @param students
     * @param scanner
     */
    public static void checkStudent(ArrayList<Student> students, Scanner scanner) throws Exception {
        System.out.println("1.查询全部\t\t2.查询单个学生\t\t3.退出");
        switch (scanner.next()) {
            //1.查询所有学员
            case "1":
                Utils.printAllMessage(students);
                break;
            //2.查询单个学员
            case "2":
                System.out.println("请输入学生id");
                int id = scanner.nextInt();
                for (Student student : students) {
                    if (student.getId() == id) {
                        Utils.printMessage(student);
                        return;
                    }
                }
                System.out.println("【错误！】查无此学生");
                break;
            //3.退出
            case "3":
                return;
            default:
                break;
        }
    }
}
