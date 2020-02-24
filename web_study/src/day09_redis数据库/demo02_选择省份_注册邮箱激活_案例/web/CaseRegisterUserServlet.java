package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.web;

import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.Result;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.service.UserService;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.JackJsonUtil;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.JedisPoolUtil;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.MailUtils;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.UUIDUtil;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
@WebServlet("/day09/caseRegisterUserServlet")
public class CaseRegisterUserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private boolean registerScucces;

    //获取前端传来的json数据
    public void register(HttpServletRequest request, HttpServletResponse response) {

        try {
            //接收客户端的数据。没有status(默认N)的值
            User user = JackJsonUtil.writer2Object(request, User.class);
            if (!"".equalsIgnoreCase(user.getUsername())){
                //调用service，把数据保存到数据库里
                registerScucces = userService.register(user);
            }

            //保存成功-->生成uuid(存在redis里)-->发拼接连接..username=?&-->发邮件-->跳转登录页面-->登录--->登录是否成功
            if (registerScucces) {
                //获取一个激活码（随机生成的字符串）
                String uuid = UUIDUtil.getUuid();
                Jedis jedis = JedisPoolUtil.getJedis();
                //把激活码缓存到redis里，保存2分钟
                jedis.setex(user.getUsername(), 60 * 2, uuid);
                jedis.close();  //注意关闭

                //发送激活邮件
                String url = "http://localhost:8080/" + request.getContextPath() + "/userLoginServlet?username=" + user.getUsername() + "&uuid=" + uuid;
                String content = "您的账号已成功注册,请在两分钟内登录网址激活"+ url;
                System.out.println("url:"+url);
                MailUtils.sendMail(user.getEmail(), content);
                //这里有问题,页面显示不出来alert.
                JackJsonUtil.printResult(response, new Result(true, "注册成功"));
//                跳转
//                response.sendRedirect("day09_redis_case/demo5_rgister_login.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JackJsonUtil.printResult(response, new Result(false, "注册失败"));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
