package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo07_第三方dbutils;

/**
 * 如果JavaBean对应一张表：建议 表的字段名  和  JavaBean的字段保持一致
 *                        JavaBean的字段名 和 属性名保持一致
 *
 * @author liuyp
 * @date 2018/01/11
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String birthday;
    private Integer age;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
