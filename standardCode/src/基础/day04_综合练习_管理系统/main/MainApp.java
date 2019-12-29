package 基础.day04_综合练习_管理系统.main;



import 基础.day04_综合练习_管理系统.student.Student;
import 基础.day04_综合练习_管理系统.teacher.Teacher;
import 基础.day04_综合练习_管理系统.utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 彭智林
 * @date 2019/12/19 10:09
 */
public class MainApp {

    public static void main(String[] args) {
        // 创建Scanner对象,用来键盘录入
        Scanner sc = new Scanner(System.in);

        // 创建ArrayList集合,限制集合中的元素为Student类型
        ArrayList<Student> stuList = new ArrayList<>();

        // 创建ArrayList集合,限制集合中的元素为Teacher类型
        ArrayList<Teacher> teaList = new ArrayList<>();



        // 循环生成一级菜单
        while (true) {
            System.out.println("1 学员信息管理  2 教师信息管理  3 系统退出");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    // 进入学员信息管理
                    studentManage(stuList, sc);
                    break;
                case 2:
                    // 进入教师信息管理
                    teacherManage(teaList, sc);
                    break;
                case 3:
                    // 系统退出
                    System.out.println("系统退出,拜拜啦!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您输入有误,请重新输入!");
                    break;
            }
        }
    }

    /**
     * 学员信息管理
     *
     * @param stuList
     * @param sc
     */
    private static void studentManage(ArrayList<Student> stuList, Scanner sc) {
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("【学员信息管理】");
            System.out.println("1.添加学员   2.查询学员  3.修改学员   4.删除学员      5.返回");
            System.out.println();
            System.out.println("请输入功能序号:");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    // 添加学员
                    addStudent(stuList, sc);
                    break;
                case 2:
                    // 查询学员
                    selectStudent(stuList, sc);
                    break;
                case 3:
                    // 修改学员
                    updateStudent(stuList, sc);
                    break;
                case 4:
                    // 删除学员
                    deleteStudent(stuList, sc);
                    break;
                case 5:
                    // 结束二级菜单,返回一级菜单
                    return;
                default:
                    System.out.println("您输入有误,请重新输入!");
                    break;
            }
        }
    }

    /**
     * 删除学员信息
     *
     * @param stuList
     * @param sc
     */
    private static void deleteStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入要删除学员的编号:");
        int sid = sc.nextInt();

        // 循环遍历stuList集合
        for (int i = 0; i < stuList.size(); i++) {
            // 在循环中,获取学生对象
            Student stu = stuList.get(i);
            // 在循环中,判断,如果遍历出来的学员id与sid相等,那么就进入删除操作,删除完后直接结束方法
            if(stu.getId() == sid){
                // 删除操作
                System.out.println("【查询结果】要删除的学员信息:");
                Utils.printPerson(stu);
                System.out.println("【确认】您确定要删除这条信息吗(y/n)?");
                String msg = sc.next();

                // 判断
                if("n".equalsIgnoreCase(msg)){
                    System.out.println("【取消】操作取消!");
                    return;
                }

                if("y".equalsIgnoreCase(msg)){
                    // 删除元素
                    stuList.remove(i);
                    System.out.println("删除成功");
                    return;
                }

                return;
            }

        }
        // 循环外,输出没有找到该编号学员的错误信息
        System.out.println("【错误】学员ID:" + sid + "未找到!");
    }

    /**
     * 修改学员信息
     *
     * @param stuList
     * @param sc
     */
    private static void updateStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入要修改学员的编号:");
        int sid = sc.nextInt();
        // 循环遍历集合中的学生对象
        for (int i = 0; i < stuList.size(); i++) {
            // 在循环中,获取学生对象
            Student stu = stuList.get(i);
            // 在循环中,如果遍历出来的学员id与sid相等,那么就进入修改操作,修改完后直接结束方法
            if (stu.getId() == sid) {
                // 修改操作
                System.out.println("请输入学员姓名(保留原值输入0):");
                String name = sc.next();

                System.out.println("请输入学员性别(保留原值输入0):");
                String sex = sc.next();

                System.out.println("请输入学员出生日期,格式为yyyy-MM-dd(保留原值输入0):");
                String birthday = sc.next();

                // 判断
                if (!"0".equals(name)) {// 输入的name不为0
                    stu.setName(name);
                }

                if (!"0".equals(sex)) {// 输入的sex不为0
                    stu.setSex(sex);
                }

                if (!"0".equals(birthday)) {// 输入的birthday不为0
                    stu.setBirthday(birthday);
                    stu.setAge(Utils.birthdayToAge(birthday));
                }
                System.out.println("修改成功");
                return;
            }

        }
        // 在循环外,打印学员编号不存在的错误信息
        System.out.println("【错误】学员ID:" + sid + "未找到!");
    }

    /**
     * 查询学员信息
     *
     * @param stuList
     * @param sc
     */
    private static void selectStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("[查询结果]");

        // 如果集合中没有学生信息,就显示没有数据...
        if (stuList.size() == 0) {
            System.out.println("没有数据...");
            return;
        }
        // 如果集合中有学生信息,就全部显示数据...
       Utils.printArrayList(stuList);
    }

    /**
     * 添加学员信息
     *
     * @param stuList
     * @param sc
     */
    private static void addStudent(ArrayList<Student> stuList, Scanner sc) {
        System.out.println("请输入学员姓名:");
        String name = sc.next();

        System.out.println("请输入学员性别:");
        String sex = sc.next();

        System.out.println("请输入出生日期(格式为yyyy-MM-dd):");
        String birthday = sc.next();

        // 创建学生对象
        Student stu = new Student();
        stu.setId(++Utils.sid);
        stu.setName(name);
        stu.setSex(sex);
        stu.setBirthday(birthday);
        stu.setAge(Utils.birthdayToAge(birthday));

        // 把学生对象添加到集合中
        stuList.add(stu);
        System.out.println("添加元素成功...");
    }

    /**
     * 教师信息管理
     *
     * @param teaList
     * @param sc
     */
    private static void teacherManage(ArrayList<Teacher> teaList, Scanner sc) {

    }


}
