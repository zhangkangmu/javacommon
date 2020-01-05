package hong.练习的包.day09_线程唤醒;

/**
 * Created by zhangyuhong
 * Date:2017/12/27
 */
public class PersonTest {
    String name;

    public PersonTest(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
