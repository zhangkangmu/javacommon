package 基础.day03_权限修饰符_代码块_常用API.demo7_equals方法;

/**
 * @author 彭智林
 * @date 2017/12/18 9:51
 */
public class Demo {
    public static void main(String[] args) {
        /*
            Object类的equals方法:
                public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。比较2个对象是否相等
                参数是Object类型: 根据多态的特点,该参数可以接收java中任意类的对象

             结论:
                1.Object类中的equals()方法默认比较的是2个对象的地址值是否相等
                2.在开发中,我们往往认为2个对象所有的属性相同,就是2个相同的对象,
                  但由于Object类的equals方法默认比较的是地址值,所以需要重写equals方法(),
                  使得equals()方法根据对象的所有属性来判断是否相等
         */
        // 需求: 比较2个Person对象是否相等
       /* // 创建1个Person对象
        Person p1 = new Person("张三", 19);
        // 创建1个Person对象
        Person p2 = new Person("张三", 19);
        // 比较
        boolean res1 = p1.equals(p2);
        System.out.println("res1:"+res1);// res1:false  比较p1和p2对象的地址值是否相等
        System.out.println(p1 == p2);// false  比较p1和p2对象的地址值是否相等*/

       // Person类重写了equals方法
        // 创建1个Person对象
        Person p1 = new Person(null, 19);
        // 创建1个Person对象
        Person p2 = new Person("张三", 19);
        // 比较
        boolean res1 = p1.equals(p2);
        System.out.println("res1:"+res1);// res1:true  比较p1和p2所有的属性是否相同
        System.out.println(p1 == p2);// false  比较p1和p2对象的地址值是否相等

    }
}
