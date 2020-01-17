package day02_response和request.response._02response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.WildcardType;

/**
 * 通过字符流设置响应体
 * @author liuyp
 * @date 201/01/16
 */
@WebServlet(urlPatterns="/day02/charbody")
public class Demo04ResponseCharBodyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 一切乱码的原因，都是：编码和解码方式不一致。
         *  比如：用gbk编码，用utf-8解码，一定乱码
         *
         * 设置中文响应体乱码：
         *      编码：response编码，用iso-8859-1字符集，不支持中文
         *      解码：浏览器解码，不一定用什么字符集解码
         *
         * 解决方案一【不推荐】：
         *      编码：设置response用utf-8字符集，支持中文了response.setCharacterEncoding("utf-8");
         *      解码：需要用户手动设置字符集为utf-8
         *
         * 解决方案二【推荐】：
         *      同时设置：  response用utf-8编码，浏览器用utf-8解码
         *      response.setContentType("text/html;charset=utf-8");
         *
         *      注意：上边这行代码，必须放在获取输入流之前，否则无效
         */

        //response.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");

        //获取到字符输出流
        PrintWriter writer = response.getWriter();
        //writer.write("hello, char body:write");

        //print方法，底层还是调用的write方法。只是功能更强
        //writer.print("hello, char body:print");

        //writer.print("你好，老弟");

        writer.print("<html>");
        writer.print("<head>");
        writer.print("<title>Servlet生成的页面</title>");
        writer.print("</head>");
        writer.print("<body>");
        writer.print("<a href='http://www.baidu.com'>百度</a>");
        writer.print("</body>");
        writer.print("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
