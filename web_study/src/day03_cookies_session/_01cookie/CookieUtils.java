package day03_cookies_session._01cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liuyp
 * @date 2020/02/07
 */
public class CookieUtils {
    /**
     * 根据Cookie名称，获取对应的值
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (cookieName.equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
