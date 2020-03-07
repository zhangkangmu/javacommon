package com.hong.mm.controller;

import com.hong.mm.entity.Result;
import com.hong.mm.pojo.Company;
import com.hong.mm.pojo.Course;
import com.hong.mm.service.CompanyService;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
@Controller
public class CompanyController {
    private CompanyService service = new CompanyService();

    @RequestMapping("/company/addQuestionQueryCompany")
    public void addQuestionQueryCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Company> companies = service.addQuestionQueryCompany();
            if (companies != null) {
                JsonUtils.printResult(response, new Result(true, "获取获取公司和行业信息成功", companies));
            } else {
                JsonUtils.printResult(response, new Result(false, "获取获取公司和行业信息失败"));
            }
        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(false, "获取获取公司和行业信息失败"));
            e.printStackTrace();
        }
    }
}
