package day01_servlet入门.demo01_servlet集成体系介绍;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet快速入门示例
 * Servlet里的方法都是非静态方法，要调用 这些方法，必须要通过对象
 * 问题：
 *  谁创建了对象？Tomcat
 *  谁调用了方法？Tomcat
 *
 * 开发人员做什么？只需要在service里写功能代码即可，其它交给Tomcat来完成了
 *
 * Servlet的生命周期：
 *      Servlet对象何时创建的？
 *          默认第一次访问Servlet时，Tomcat会创建Servlet对象，只创建一次
 *
 *      Servlet对象何时销毁的？
 *          当服务器关闭时，Servlet对象会被销毁。销毁时Tomcat会执行一次destroy方法
 *
 *      客户端每次访问Servlet对象，必定执行的方法是？service方法
 *
 *      假如有一个Demo01Servlet，部署启动之后：客户端访问了10次，然后服务器关闭了
 *      问：
 *          Demo01Servlet类，只有一个对象存在
 *          init方法执行了几次：一次
 *          destroy方法执行几次：一次
 *          service方法执行了几次：10次
 *
 * @author liuyp
 * @date 2018/01/15
 */
/*@WebServlet(value = "/demo01", initParams = {
  @WebInitParam(name = "aa", value = "AA")
})*/
/*@WebServlet(value = "/demo01", loadOnStartup = 1)*/
@WebServlet(value = "/day01/demo01")
public class Demo01QuickStartServlet implements Servlet {

    /**
     * 在Servlet对象被创建之后，Tomcat会调用一次init方法
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("===Demo01QuickStartServlet.init===");

        /**
         * ServletConfig：当前Servlet的配置信息对象，由Tomcat创建后传递进来的，我们可以直接使用
         */
        //1. 获取Servlet的名称
        String servletName = config.getServletName();
        System.out.println("Servlet名称：" + servletName);

        //2. 获取Servlet的初始化参数【目前已经基本不用】
        String aa = config.getInitParameter("aa");
        System.out.println("初始化参数aa：" + aa);

        //3. 获取ServletContext【不用】
        ServletContext context = config.getServletContext();
        System.out.println(context);
    }

    /**
     * 业务处理的方法
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("===Demo01QuickStartServlet.service===");

        /**
         * ServletRequest：代表HTTP请求的request对象，可以用来接收客户端提交的数据
         *      获取客户端提交的表单参数：String value = request.getParameter("表单项的名称")
         *
         * ServletResponse：代表HTTP响应的response对象，可以用来给客户端返回数据
         *      response.getWriter().print(String content)
         */
        String username = request.getParameter("username");
        System.out.println("接收到客户端提交的表单参数username：" + username);



        response.getWriter().print("hello, " + username);
    }

    /**
     * 当Servlet对象被销毁时，Tomcat会调用一次destroy方法
     */
    @Override
    public void destroy() {
        System.out.println("===Demo01QuickStartServlet.destroy===");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
