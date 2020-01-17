package day02_response和request.response._02response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用字节流的方式，设置响应体
 * @author liuyp
 * @date 201/01/16
 */
@WebServlet(urlPatterns="/day02/bytebody")
public class Demo05ResponseByteBodyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        //要求：把WEB-INF/files/a.jpg 返回给客户端

        //1. 获取字节型输出流
        ServletOutputStream os = response.getOutputStream();
        //2. 获取a.jpg文件的输入流
        InputStream is = context.getResourceAsStream("WEB-INF/files/a.jpg");
        //3. 读数据，通过输出流写出
        int len = -1;
        byte[] buffer = new byte[1024 * 8];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        //4. 关闭流
        is.close();
        os.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
