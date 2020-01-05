package 基础.day06_Collections_Set_Map_斗地主排序.demo14_HashMap存储自定义类型;

import java.util.HashMap;

/**
 * @author 彭智林
 * @date 2017/12/22 15:12
 */
public class Demo {
    public static void main(String[] args) {
        /*
            HashMap存储自定义类型:
            练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，
                  则将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。
            注意，学生姓名相同并且年龄相同视为同一名学生。

            HashMap集合是由哈希表保证键唯一的,而哈希表保证键唯一依赖hashCode()和equals()方法
            结论:
                HashMap集合中的键如果是自定义类型的对象,那么该自定义类型需要重写hashCode()和equals()方法
         */
        // 创建Map集合,指定键的类型为Student,值的类型为String
        HashMap<Student,String> map = new HashMap<>();

        // 创建多个学生对象
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 38);
        Student stu3 = new Student("王五", 28);
        Student stu4 = new Student("张三", 18);

        // 把学生对象作为键,家庭地址作为值,存储到map集合中
        map.put(stu1,"北京");
        map.put(stu2,"上海");
        map.put(stu3,"深圳");
        map.put(stu4,"广州");

        // 打印map集合
        System.out.println(map);
        System.out.println(map.size());// 3
    }
}
