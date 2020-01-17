package day02_response和request.request._01request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求头
 *      请求头格式：键值对
 *
 * @author liuyp
 * @date 2018/01/16
 */
@WebServlet(urlPatterns="/day02/request/header")
public class Demo02RequestHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);

        String referer = request.getHeader("Referer");
        System.out.println("请求头Referer：" + referer);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
