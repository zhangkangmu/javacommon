package day03_cookies_session._01cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于：创建Cookie，验证Cookie的有效范围
 * @author liuyp
 * @date 2020/02/07
 */
@WebServlet(urlPatterns="/aa/createCookie")
public class Demo03CreateCookiePathServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
           当客户端访问：http://localhost:80/day09/aa/createCookie时，会生成一个Cookie，给客户端

           当客户端访问：http://localhost:80/day09/recieveCookie时：客户端会不会把Cookie携带过来？不会
           当客户端访问：http://localhost:80/day09/aa/recieveCookie时：客户端会不会把Cookie携带过来？会


            并非客户端访问任意资源时，都会把Cookie携带到服务端。只有访问有效范围内的资源时，才会携带到服务端

            那么：Cookie的默认有效范围是什么？是生成Cookie的资源所在的目录

                生成Cookie的资源是：  http://localhost:80/day09/aa/createCookie
                那么Cookie有效范围是：http://localhost:80/day09/aa
                客户端访问：
                                    http://localhost:80/day09/aa/recieveCookie，在有效范围
                                    http://localhost:80/day09/aa/bb/recieveCookie，在有效范围
                                    http://localhost:80/day09/recieveCookie，不在有效范围


            可以设置Cookie的有效范围：cookie.setPath(String path)
                生成Cookie的资源是：  http://localhost:80/day09/aa/createCookie
                设置了有效范围是：    http://localhost:80/day09
                客户端访问：
                                    http://localhost:80/day09/aa/recieveCookie，在有效范围
                                    http://localhost:80/day09/aa/bb/recieveCookie，在有效范围
                                    http://localhost:80/day09/recieveCookie，在有效范围
         */

        Cookie cookie = new Cookie("path", "path");
        cookie.setPath("/day09");
        response.addCookie(cookie);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
