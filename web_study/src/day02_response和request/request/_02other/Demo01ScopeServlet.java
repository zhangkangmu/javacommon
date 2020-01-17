package day02_response和request.request._02other;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * scope：指域对象
 *
 *
 * @author liuyp
 * @date 2018/01/16
 */
@WebServlet(urlPatterns="/day02/scope1")
public class Demo01ScopeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error","我错了");

        Object error = request.getAttribute("error");
        System.out.println("scope1里获取error：" + error);

        //如果我们能跳转到scope2，并且把request传递过去：
        //response.sendRedirect(request.getContextPath() + "/scope2");

        //请求转发跳转： 路径前边不需要有项目路径（服务端跳转时，都不需要项目路径）
        request.getRequestDispatcher("/scope2").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
