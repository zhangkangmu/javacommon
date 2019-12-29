package 基础.day04_综合练习_管理系统.superclass;

/**
 * @author 彭智林
 * @date 2019/12/19 9:37
 */
public abstract class Person {
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 年龄
     */
    private int age;

    public Person(int id, String name, String sex, String birthday, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
    }

    public Person() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 供子类重写,实现返回各自类型的字符串
     * @return
     */
    public abstract String getType();

    /**
     * 供子类重写,实现返回各自工作的字符串
     * @return
     */
    public abstract String getWork();

}
