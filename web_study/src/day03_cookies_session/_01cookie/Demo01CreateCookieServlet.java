package day03_cookies_session._01cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于：创建Cookie并返回给客户端
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/createCookie")
public class Demo01CreateCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在响应头里，返回给客户端  Set-Cookie: aa=AA

        //1. 创建Cookie
        Cookie cookie = new Cookie("aa", "AA60");
        cookie.setMaxAge(60);

        //2. 把Cookie返回给客户端
        response.addCookie(cookie);


        //可以给客户端返回多少个Cookie？
        //sun公司规定：
        //一个web应用可以给浏览器返回20个（实际上，不同浏览器不同），
        //浏览器最多接收300个（实际上，不同浏览器不同）
        //每个Cookie限制4Kb【记住】

        //              http://localhost:80/day09/createCookie生成的Cookie
        //默认有效范围是：http://localhost:80/day09

        Cookie cookie1 = new Cookie("bb", "BB");
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("cc", "CC");
        response.addCookie(cookie2);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
