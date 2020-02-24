package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
public class JackJsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void printResult(HttpServletResponse response, Object obj) {
        response.setContentType("application/json;charset=utf-8");
        try {
            mapper.writeValue(response.getWriter(), obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T writer2Object(HttpServletRequest req, Class<T> tClass) throws IOException {
        return mapper.readValue(req.getInputStream(), tClass);
    }
}
