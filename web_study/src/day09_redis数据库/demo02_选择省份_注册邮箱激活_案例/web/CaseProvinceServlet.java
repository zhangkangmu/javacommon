package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.web;


import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.Result;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.service.ProvinceService;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.JackJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/day09/caseServlet")
public class CaseProvinceServlet extends HttpServlet {
    private ProvinceService service=new ProvinceService();
    public void queryProvince(HttpServletRequest request, HttpServletResponse response){
        try {
            String provinceJson = service.queryProvince();
         //这里传递的是json字符串,而不是json对象
            JackJsonUtil.printResult(response,new Result(provinceJson,true,"成功获取省数据"));
        } catch (Exception e) {
            e.printStackTrace();
            JackJsonUtil.printResult(response,new Result(false,"获取省数据失败!"));
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
