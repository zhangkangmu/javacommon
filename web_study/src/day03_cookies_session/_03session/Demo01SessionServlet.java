package day03_cookies_session._03session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/session1")
public class Demo01SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            HttpSession session = request.getSession()。方法底层源码在Tomcat里，伪代码如下：

                从request里获取名称为JSESSIONID的Cookie的值
                if JSESSIONID为空：
                    创建一个session对象
                    把session的id，放到Cookie里，添加到响应,最终返回客户端

                else JSESSIONID非空：
                    根据JSESSIONID的值，查找对应的session对象
                    if 找到了：
                        返回session对象
                    else找不到：
                        创建一个session对象
                        把session的id，放到Cookie里，添加到响应 ，最终返回客户端


            作用有两个：创建新的session，获取旧的session。
            问题：
                什么时候会创建新的session？
                    客户端没有JSESSIONID，或者  服务端没有对应的session对象：创建新的

                什么时候会获取旧的session？
                    客户端有JSESSIONID， 并且  服务端有对应的session对象：   获取旧的

            session的id，会被Tomcat以Cookie形式返回客户端：Tomcat自动做的
         */


        //得到一个session对象
        HttpSession session = request.getSession();

        //向session里存储数据
        session.setAttribute("user","张三" );

        String id = session.getId();
        System.out.println("session1里id：" + id);


        session.invalidate();
        session = request.getSession();
        System.out.println("sessoin1里销毁后获取：" + session.getId());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}