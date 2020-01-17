package day02_response和request.response._02response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应行
 * @author liuyp
 * @date 201/01/16
 */
@WebServlet(urlPatterns="/day02/response/line")
public class Demo02ResponseLineServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Tomcat会设置响应状态码
        常见响应状态码：
            200：一切正常
            302：让浏览器跳转指定路径=E》重定向
            304：让浏览器取缓存
            404：告诉浏览器，请求的资源不存在
            500：告诉浏览器，服务器内部错误
         */


        //设置响应状态码
        //response.setStatus(304);

        response.sendError(404);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
