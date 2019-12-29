package 基础.day03_权限修饰符_代码块_常用API.demo2_访问权限;


import 基础.day03_权限修饰符_代码块_常用API.demo1_访问权限.Person;

/**
 * @author 彭智林
 * @date 2019/12/18 8:58
 */
public class Teacher extends Person {
    @Override
    public void show() {
        System.out.println(name);
    }
}
