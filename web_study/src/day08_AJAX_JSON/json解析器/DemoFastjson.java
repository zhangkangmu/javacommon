package day08_AJAX_JSON.json解析器;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import day08_AJAX_JSON.domain_JsonFormmat_ignore.User;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fastjson使用示例
 * @author liuyp
 * @date 2020/02/17
 */
public class DemoFastjson {
    /**
     * 把Java对象里的数据，转换成json格式的字符串
     */
    @Test
    public void test1() {
        User user1 = new User(1, "小张", "男");
        User user2 = new User(2, "小王", "女");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("u1", user1);
        userMap.put("u2", user2);

        //1. 把一个User对象(user1)的数据，转换成json格式字符串： {"id":1,"name":"小张","sex":"男"}
        String json = JSON.toJSONString(user1);
        System.out.println(json);

        //2. 把User的集合里(userList)数据，转换成json格式字符串: [{"id":1,"name":"小张","sex":"男"},{"id":2,"name":"小王","sex":"女"}]
        json = JSON.toJSONString(userList);
        System.out.println(json);

        //3. 把User的Map里数据，转换成json格式字符串: {"u1":{"id":1,"name":"小张","sex":"男"},"u2":{"id":2,"name":"小王","sex":"女"}}
        json = JSON.toJSONString(userMap);
        System.out.println(json);
    }

    /**
     * 把json格式字符串，转换成一个User对象
     * {"id":1,"name":"小张","sex":"男"}
     */
    @Test
    public void test2() {
        String json = "{\"id\":1,\"name\":\"小张\",\"sex\":\"男\"}";

        User user = JSON.parseObject(json, User.class);
        System.out.println(user.getName());
    }

    /**
     * 把json格式字符串，转换成一个User集合
     * [{"id":1,"name":"小张","sex":"男"},{"id":2,"name":"小王","sex":"女"}]
     */
    @Test
    public void test3() {
        String json = "[{\"id\":1,\"name\":\"小张\",\"sex\":\"男\"},{\"id\":2,\"name\":\"小王\",\"sex\":\"女\"}]";

        TypeReference<List<User>> ref = new TypeReference<List<User>>(){};
        List<User> userList = JSON.parseObject(json, ref);

        for (User user : userList) {
            System.out.println(user.getName());
        }
    }

    /**
     * 把json格式字符串，转换成一个User的Map
     * {"u1":{"id":1,"name":"小张","sex":"男"},"u2":{"id":2,"name":"小王","sex":"女"}}
     */
    @Test
    public void test4(){
        String json = "{\"u1\":{\"id\":1,\"name\":\"小张\",\"sex\":\"男\"},\"u2\":{\"id\":2,\"name\":\"小王\",\"sex\":\"女\"}}";

        TypeReference<Map<String,User>> ref = new TypeReference<Map<String,User>>(){};
        Map<String, User> map = JSON.parseObject(json, ref);

        for (Map.Entry<String, User> entry : map.entrySet()) {
            String key = entry.getKey();
            User user = entry.getValue();

            System.out.println("key: " + key + ", value里用户的姓名：" + user.getName());
        }
    }
}
