package day02_response和request.response._02response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应头
 * @author liuyp
 * @date 201/01/16
 */
@WebServlet(urlPatterns="/day02/response/header")
public class Demo03ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("name", "zhangsan");

        //响应头 refresh。 让浏览器延迟跳转，值格式：  延迟秒数;url=跳转路径
        //response.setHeader("refresh","3;url=http://www.jd.com");

        //响应头 location。和302状态码配合，实现重定向跳转

        /*System.out.println("===Demo03运行了，即将跳转到京东首页===");
        response.setStatus(302);
        response.setHeader("location", "http://www.jd.com");*/

        System.out.println("===Demo03运行了，即将跳转到我们的首页===");
        /*response.setStatus(302);
        response.setHeader("location", "/day08/index.html");*/

        response.sendRedirect("/day08/index.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
