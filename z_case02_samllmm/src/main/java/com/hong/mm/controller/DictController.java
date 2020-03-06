package com.hong.mm.controller;

import com.hong.mm.entity.Result;
import com.hong.mm.pojo.Course;
import com.hong.mm.pojo.Dict;
import com.hong.mm.service.DictService;
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
public class DictController {
    private DictService service=new DictService();
    /**
     * 城市联极
     */
    @RequestMapping("/dict/addQuestionQueryDict")
    public void addQuestionQueryDict(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Dict> dicts = service.addQuestionQueryDict();
            if (dicts != null && dicts.size() > 0) {
                JsonUtils.printResult(response, new Result(true, "获取省市成功",dicts));
            } else {
                JsonUtils.printResult(response, new Result(false, "获取省市失败"));
            }

        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(false, "获取省市失败"));
            e.printStackTrace();
        }
    }
}
