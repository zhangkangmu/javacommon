package day01_servlet入门.demo01_servlet集成体系介绍;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 创建Servlet的方式一：
 *      创建Java类，实现Servlet接口的方式：除了service方法我们会用，其它都不用，但是又必须写
 * @author liuyp
 * @date 2018/01/15
 */
@WebServlet("/day01/demo02")
public class Demo02Servlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("===Demo02Servlet.service===");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
