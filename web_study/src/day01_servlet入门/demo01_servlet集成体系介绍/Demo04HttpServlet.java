package day01_servlet入门.demo01_servlet集成体系介绍;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建Servlet的方式一：
 *      创建Java类，实现Servlet接口的方式：除了service方法我们会用，其它都不用，但是又必须写
 * 创建Servlet的方式二：
 *      GenericServlet实现了Servlet接口
 *          实现了init方法、destroy方法
 *          保留了抽象方法service
 *
 *      我们创建Java类，继承GenericServlet
 *          重写service方法即可，其它方法不用管了
 *
 *      好处：简单
 *      坏处：不支持HTTP协议
 *
 * 创建Servlet的方式三：
 *      GenericServlet，实现了Servlet接口
 *          保留了抽象方法service
 *
 *      HttpServlet，继承了GenericServlet
 *          重写了service(ServletRequest, ServletResponse)方法：
 *              调用另外一个service(httpServletRequest, HttpServletResponse)方法
 *
 *          在service(httpServletRequest, HttpServletResponse)方法里：
 *              获取了请求方式
 *              if get方式：调用doGet方法
 *              if post方式：调用doPost方法
 *              ...
 *
 *      我们创建Java类，继承HttpServlet
 *          重写doGet方法
 *          重写doPost方法
 *
 * @author liuyp
 * @date 2018/01/15
 */
@WebServlet("/day01/demo04")
public class Demo04HttpServlet extends HttpServlet {

    /**
     * 处理GET方式的请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("doGet");
        System.out.println("登录校验的功能代码");
    }

    /**
     * 处理POST方式的请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("doPost");
        doGet(req, resp);
    }
}
