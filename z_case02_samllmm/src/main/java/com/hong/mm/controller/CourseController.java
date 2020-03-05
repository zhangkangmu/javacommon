package com.hong.mm.controller;

import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Course;
import com.hong.mm.service.CourseService;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import com.hong.mm.entity.Result;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
@Controller
public class CourseController {
    private CourseService courseService = new CourseService();

    /**
     * 退出登录的功能
     */
    @RequestMapping("/course/pageList")
    public void pageList(HttpServletRequest request, HttpServletResponse response) throws IOException{
        QueryPageBean pageBean = null;
        try {
            pageBean = JsonUtils.parseJSON2Object(request, QueryPageBean.class);

//       要返回什么数据,得看前端,一般他们会被一些假数据,我们根据假数据要设置bean就可以
            //获取
            PageResult pageList = courseService.getPageList(pageBean);
            if (pageList != null) {
                JsonUtils.printResult(response, new Result(true, "查询学科列表成功", pageList));
            }else {
                JsonUtils.printResult(response, new Result(true, "查询学科列表失败"));
            }
            System.out.println("pageBean:" + pageBean);
        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(true, "查询学科列表失败"));
            e.printStackTrace();
        }
    }
}
