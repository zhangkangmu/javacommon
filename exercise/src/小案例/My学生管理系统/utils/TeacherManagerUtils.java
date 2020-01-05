package 小案例.My学生管理系统.utils;

import 小案例.My学生管理系统.teacher.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhangyuhong
 * Date:2017/12/19
 */
public class TeacherManagerUtils {


    /**
     * 增加学生到学生管理系统的方法
     *
     * @param teachers
     * @param scanner
     */
    public static void addTeacher(ArrayList<Teacher> teachers, Scanner scanner) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(++Utils.tId);
        System.out.println("请输入老师姓名");
        teacher.setName(scanner.next());
        System.out.println("请输入老师性别");
        teacher.setSex(scanner.next());
        System.out.println("请输入老师出生日期（格式：xxxx-xx-xx）");
        teacher.setBirthday(scanner.next());

//        teacher.setAge(StudentManagerUtils.calculateAge(teacher.getBirthday()));
        teachers.add(teacher);
        System.out.println("增加老师完成！");
        System.out.println("***********************************************************************");
    }

    /**
     * 修改学生信息
     */
    public static void modifyStudent(ArrayList<Teacher> teachers, Scanner scanner) {
        System.out.println("请输入修改的学生id");
        int id = scanner.nextInt();
        for (Teacher teacher : teachers) {
            if (id == teacher.getId()) {
                System.out.println("请输入老师姓名");
                teacher.setName(scanner.next());
                System.out.println("请输入老师性别");
                teacher.setSex(scanner.next());
                System.out.println("请输入老师出生日期（格式：xxxx-xx-xx）");
                teacher.setBirthday(scanner.next());
                System.out.println("修改老师完成！");
                System.out.println("***********************************************************************");
                return;
            }
        }
        System.out.println("查无此学生！");
    }


    public static void deleteStudent(ArrayList<Teacher> teachers, Scanner scanner) {
        System.out.println("请输入要删除的老师id");
        int id = scanner.nextInt();
        for (Teacher teacher : teachers) {
            if (id == teacher.getId()) {
                teachers.remove(teacher);
                return;
            }
        }
        System.out.println("查无此老师！");
    }


    /**
     * 查询学生功能
     *
     * @param teachers
     * @param scanner
     */
    public static void checkTeacher(ArrayList<Teacher> teachers, Scanner scanner) throws Exception {
        System.out.println("1.查询全部\t\t2.查询单个学生\t\t3.退出");
        switch (scanner.next()) {
            //1.查询所有学员
            case "1":
                Utils.printAllMessage(teachers);
                break;
            //2.查询单个学员
            case "2":
                System.out.println("请输入学生id");
                int id = scanner.nextInt();
                for (Teacher teacher : teachers) {
                    if (teacher.getId() == id) {
                        Utils.printMessage(teacher);
                        return;
                    }
                }
                System.out.println("【错误！】查无老师");
                break;
            //3.退出
            case "3":
                return;
            default:
                break;
        }
    }
}
