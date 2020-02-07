package day03_cookies_session._01cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于：接收客户端携带过来的Cookie
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/recieveCookie")
public class Demo02RecieveCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在请求头，把Cookie携带到服务端   Cookie: aa=AA
        //只能接收Cookie的名称name和值value。其它数据接收不到
        // 客户端发送的HTTP请求头中，只有Cookie的名称和值，其它数据没有携带到服务端，所以是接收不到的

        //接收客户端携带的Cookie
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();

            int maxAge = cookie.getMaxAge();
            String path = cookie.getPath();

            System.out.println(name + ":  " + value + ", maxAge: " + maxAge + ", path: " + path);
        }*/


        //要求：获取名称为aa的Cookie的值
        String cookieName = "bb";
        String value = CookieUtils.getCookieValue(request, cookieName);

        /*Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (cookieName.equals(name)) {
                    value = cookie.getValue();
                    break;
                }
            }
        }*/

        System.out.println("bb的值：" + value);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
