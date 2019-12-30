package hong.练习的包.z其他;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.naming.Name;
import java.io.Serializable;

/**
 * Created by zhangyuhong
 * Date:2019/12/22
 */
public class Person implements Serializable {
    static final long serialVersionUID = 42L;
    private String name;
    private String sex;
    private transient String home;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", home='" + home + '\'' +
                ", age=" + age +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String sex, String home, int age) {
        this.name = name;
        this.sex = sex;
        this.home = home;
        this.age = age;
    }
}
