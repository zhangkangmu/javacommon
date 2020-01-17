package day02_response和request.request._01request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求的行数据。
 *  请求行的格式：请求方式 请求资源 协议版本
 *               POST    /day08/line  HTTP/1.1
 * @author liuyp
 * @date 2018/01/16
 */
@WebServlet(urlPatterns="/day02/line")
public class Demo01RequestLineServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求方式。什么样的请求是GET？什么样的请求是POST？
        /**
         * 浏览器直接输入地址：GET
         * 超链接发请求：GET
         * 表单提交：指定是什么，请求方式就是什么
         * js的location.href：GET
         *
         * 总结：默认请求方式是GET；指定了POST，才是POST
         *
         */

        String method = request.getMethod();
        System.out.println("请求方式：" + method);


        //2. 获取项目路径【重点】
        String contextPath = request.getContextPath();
        System.out.println("项目路径是：" + contextPath);

        response.sendRedirect(contextPath +"/index.html");

        //拓展了解：
        /*
            url：统一资源定位符
            uri：统一资源标识符

            我们认为：
                绝对路径是url
                所有路径都是是uri
         */
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        System.out.println("uri: " + uri);
        System.out.println("url: " + url);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
