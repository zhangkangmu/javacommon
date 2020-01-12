package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo07_第三方dbutils;

/**
 * JavaBean：符合以下条件的简单Java类
 * 1. 成员变量/字段私有
 * 2. 每个字段应该有public的get/set方法
 * 3. 应该有无参构造
 * 4. 实现Serializable接口（非必须）
 *
 *
 * 字段：JavaBean里的成员变量，name、age
 * 属性：JavaBean里的get/set方法，去掉get/set，首字段小写，得到属性，name1,age
 *
 * 实际开发中，要求字段和属性名保持一致。
 *
 * @author liuyp
 * @date 2020/01/11
 */
public class Person {

    private String name;
    private Integer age;

    public String getName1() {
        return name;
    }

    public void setName1(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
