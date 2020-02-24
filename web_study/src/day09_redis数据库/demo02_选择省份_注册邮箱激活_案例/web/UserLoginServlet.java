package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.web;

import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.UserDao;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.service.UserService;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数--激活链接的数据--用户名和uuid
        String username = request.getParameter("username");
        String uuid = request.getParameter("uuid");
        //从redis里得到真实的验证码
        Jedis jedis = JedisPoolUtil.getJedis();
        String cacheUUid = jedis.get(username);
        System.out.println("username:" + username + "----uuid:" + uuid + "---cacheUUid:" + cacheUUid);
        //比较：用户提交的验证码，和redis里缓存的验证码是否一致
        if (cacheUUid.equalsIgnoreCase(uuid) && uuid != null && !"".equalsIgnoreCase(uuid)) {
            try {
                boolean active = userService.active(username);
                System.out.println("active:" + active);
                if (active) {
                    response.getWriter().print("激活成功，请登录");
                    //跳转登录页面
                    response.sendRedirect("day09_redis_case/demo5_rgister_login.html");
                } else {
                    response.getWriter().print("激活失败，请重新激活或重新发送激活邮件");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
