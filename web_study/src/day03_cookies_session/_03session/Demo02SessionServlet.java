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
@WebServlet(urlPatterns="/session2")
public class Demo02SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到session对象
        HttpSession session = request.getSession();
        //从session里取数据
        Object user = session.getAttribute("user");

        String id = session.getId();
        System.out.println("session2里：user是 " + user + ", id: " + id);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}