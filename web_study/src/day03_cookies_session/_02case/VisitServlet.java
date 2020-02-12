package day03_cookies_session._02case;


import day03_cookies_session._01cookie.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuyp
 * @date 2020/02/07
 * 显示上次访问时间
 */
@WebServlet(urlPatterns="/visit")
public class VisitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把本次访问时间，放到Cookie里，返回客户端。注意：Cookie的名称和值，建议使用字母、数字、下划线。避免用特殊字符和空格
        Cookie cookie = new Cookie("visitTime", System.currentTimeMillis()+"");
        cookie.setMaxAge(30*24*60*60);
        response.addCookie(cookie);

        //获取客户端携带的名称为visitTime的Cookie，显示到浏览器页面上
        response.setContentType("text/html;charset=utf-8");
        String visitTime = CookieUtils.getCookieValue(request, "visitTime");
        if (visitTime == null || "".equals(visitTime)) {
            response.getWriter().print("你是第一次访问");
        }else{
            //visitTime是上次访问时间，是毫秒值。要显示到浏览器页面上的是：xxxx年xx月xx日  xx:xx:xx

            //1.把visitTime毫秒值，转换成Date对象
            Date date = new Date(Long.parseLong(visitTime));
            //2.格式化Date对象，转换成yyyy-MM-dd HH:mm:ss格式的字符串
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            response.getWriter().print("你上次访问时间是：" + format.format(date));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
