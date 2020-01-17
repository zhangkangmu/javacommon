package day02_response和request.response._01context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(urlPatterns="/day02/context01")
public class Demo01ContextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象

        ServletContext context = getServletContext();

        System.out.println("Demo01里获取：" + context);

        //读取web文件夹里的资源：用ServletContext
        /*InputStream is = context.getResourceAsStream("aaa.properties");
        Properties properties = new Properties();
        properties.load(is);

        String a = properties.getProperty("a");
        System.out.println(a);

        is.close();*/

        /*InputStream is = context.getResourceAsStream("WEB-INF/aaaa.properties");
        Properties properties = new Properties();
        properties.load(is);

        String a = properties.getProperty("a");
        System.out.println(a);

        is.close();*/


        //读取src文件夹里的资源：用类加载器
        /*InputStream is = Demo01ContextServlet.class.getClassLoader().getResourceAsStream("bbb.properties");
        Properties properties = new Properties();
        properties.load(is);

        String b = properties.getProperty("b");
        System.out.println(b);

        is.close();*/

        /*InputStream is = Demo01ContextServlet.class.getClassLoader().getResourceAsStream("com/itheima/_01context/bbbb.properties");
        Properties properties = new Properties();
        properties.load(is);

        String b = properties.getProperty("b");
        System.out.println(b);

        is.close();*/


        //向ServletContext里存储数据
        context.setAttribute("name", "2哥");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
