package com.hong.mm.controller;

import com.hong.mm.entity.Result;
import com.hong.mm.pojo.Industry;
import com.hong.mm.service.IndustryService;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
@Controller
public class IndustryController {
    private IndustryService service=new IndustryService();
    @RequestMapping("/industry/addQuestionQueryIndustry")
    public void addQuestionQueryIndustry(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Industry> industries = service.addQuestionQueryIndustry();
            if (industries != null && industries.size()>0) {
                JsonUtils.printResult(response,new Result(true,"查询行业成功",industries));

            }else {
                JsonUtils.printResult(response,new Result(false,"查询行业失败"));
            }
        } catch (IOException e) {
            JsonUtils.printResult(response,new Result(false,"查询行业失败"));
            e.printStackTrace();
        }
    }
}
