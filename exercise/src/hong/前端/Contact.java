package hong.前端;

/**
 * Created by zhangyuhong
 * Date:2019/12/18
 */
public class Contact {
    private String id;
    private String UID;
    private String name;
    private String age;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id属性='" + id + '\'' +
                ", UID元素='" + UID + '\'' +
                ", name元素='" + name + '\'' +
                ", age元素='" + age + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
