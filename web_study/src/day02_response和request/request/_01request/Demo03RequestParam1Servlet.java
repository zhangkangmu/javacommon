package day02_response和request.request._01request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @author liuyp
 * @date 2018/01/16
 */
@WebServlet(urlPatterns="/day02/param1")
public class Demo03RequestParam1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收单值的表单项：username
        String username = request.getParameter("username");
        System.out.println("username: " + username);

        System.out.println("--------------------------");

        //2. 接收多值的表单项：hobby
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("hobby: " + Arrays.toString(hobbies));

        System.out.println("--------------------------");

        //3. 接收所有的表单项
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            //key：表单项的name
            String key = entry.getKey();
            //value：表单项的值
            String[] value = entry.getValue();

            System.out.println(key + ":  " + Arrays.toString(value));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
