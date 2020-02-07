package day03_cookies_session._01cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于：接收客户端携带的Cookie，验证有效范围
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/aa/recieveCookie")
public class Demo04RecieveCookiePathServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("/aa/createCookie,  " + name + ": " + value);

            System.out.println("--zzzzz--"+cookie.getPath());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
