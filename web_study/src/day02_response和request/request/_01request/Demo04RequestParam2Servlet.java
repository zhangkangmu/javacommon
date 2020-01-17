package day02_response和request.request._01request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端提交的表单参数，中文乱码的解决方案
 * @author liuyp
 * @date 2018/01/16
 */
@WebServlet(urlPatterns="/day02/param2")
public class Demo04RequestParam2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 客户端提交中文参数：
         *  GET方式提交的，中文没有乱码：Tomcat8帮我们解决了
         *
         *  POST方式提交的，中文乱码了。 编码和解码方式不一致
         *      编码：客户端使用的utf-8
         *      解码：request对象默认使用iso-8859-1
         *
         *      解决方案：设置request使用utf-8。
         *          request.setCharacterEncoding("utf-8")
         *          注意：上边这行代码，必须要在 第一次接收参数之前，先设置；否则无效
         */

        request.setCharacterEncoding("utf-8");

        String method = request.getMethod();
        String username = request.getParameter("username");

        System.out.println("请求方式：" + method + "，提交的参数：" + username);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
