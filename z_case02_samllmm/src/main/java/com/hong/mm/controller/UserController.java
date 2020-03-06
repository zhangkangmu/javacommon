package com.hong.mm.controller;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.User;
import com.hong.mm.service.UserService;
import com.hong.mm.utils.JedisUtils;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hong.mm.entity.Result;

/**
 * Created by zhangyuhong
 * Date:2020/3/3
 */
@Controller
public class UserController {
    private UserService service = new UserService();

    /**
     * 用户登录
     */
    @RequestMapping("/user/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = JsonUtils.parseJSON2Object(request, User.class);
            if (user != null) {
                User loginUser = service.login(user);
                if (loginUser != null) {
                    request.getSession().setAttribute("user", loginUser);
                    JsonUtils.printResult(response, new Result(true, "登录成功"));
                } else {
                    JsonUtils.printResult(response, new Result(false, "登录失败"));
                }
            }
        } catch (IOException e) {
            JsonUtils.printResult(response, new Result(false, "登录失败"));
            e.printStackTrace();
        }
    }

    /**
     * 退出登录的功能
     */
    @RequestMapping("/user/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getSession().removeAttribute("user");
            JsonUtils.printResult(response,new Result(true,"退出登录成功!"));
        } catch (IOException e) {
            JsonUtils.printResult(response,new Result(false,"退出登录收失败!"));
            e.printStackTrace();
        }
    }

}
