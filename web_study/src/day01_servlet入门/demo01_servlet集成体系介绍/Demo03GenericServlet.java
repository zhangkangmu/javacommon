package day01_servlet入门.demo01_servlet集成体系介绍;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
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
 * @author liuyp
 * @date 2018/01/15
 */
@WebServlet("/day01/demo03")
public class Demo03GenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("==Demo03GenericServlet.service===");
    }
}
