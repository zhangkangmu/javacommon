package 小案例.My学生管理系统.superclass;

import 小案例.My学生管理系统.utils.Utils;

/**
 * Created by zhangyuhong
 * Date:2017/12/19
 */
public abstract class Person {
    /**
     * 学生id
     */
    private int id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生
     */
    private String birthday;
    /**
     * 年龄
     */
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() throws Exception {
        return Utils.calculateAge(getBirthday());
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String describe() {
        return "我是一名：" + identity() + ",我的工作是：" + workType();
    }

    public abstract String identity();

    public abstract String workType();

}
