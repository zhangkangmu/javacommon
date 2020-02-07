package day03_cookies_session._01cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/deleteCookie")
public class Demo05DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //要删除客户端的  名称为bb，path为/day09的Cookie

        Cookie cookie = new Cookie("bb", "");
        cookie.setPath("/day09");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
