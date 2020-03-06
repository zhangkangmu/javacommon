package com.hong.mm.controller;

import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Course;
import com.hong.mm.pojo.User;
import com.hong.mm.service.CourseService;
import com.hong.mm.utils.DateUtils;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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
    public void pageList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        QueryPageBean pageBean = null;
        try {
            pageBean = JsonUtils.parseJSON2Object(request, QueryPageBean.class);

//       要返回什么数据,得看前端,一般他们会被一些假数据,我们根据假数据要设置bean就可以
            //获取
            PageResult pageList = courseService.getPageList(pageBean);
            if (pageList != null) {
                JsonUtils.printResult(response, new Result(true, "查询学科列表成功", pageList));
            } else {
                JsonUtils.printResult(response, new Result(true, "查询学科列表失败"));
            }
        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(true, "查询学科列表失败"));
            e.printStackTrace();
        }
    }


    /**
     * 增加学科功能
     */
    @RequestMapping("/course/addCourse")
    public void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            course.setCreateDate(DateUtils.parseDate2String(new Date()));
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                course.setUserId(user.getId());
            }
            boolean addSuccess = courseService.addCourse(course);
            if (addSuccess) {
                JsonUtils.printResult(response, new Result(true, "增加学科成功"));
            } else {
                JsonUtils.printResult(response, new Result(false, "增加学科失败"));
            }
        } catch (IOException e) {
            JsonUtils.printResult(response, new Result(false, "增加学科失败"));
            e.printStackTrace();
        }
    }

    /**
     * 修改学科功能
     */
    @RequestMapping("/course/updataCourse")
    public void updataCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            boolean updataSuccess = courseService.updataCourse(course);
            if (updataSuccess) {
                JsonUtils.printResult(response, new Result(true, "修改科目成功"));
            } else {
                JsonUtils.printResult(response, new Result(false, "修改科目失败"));
            }
        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(false, "修改科目失败"));
            e.printStackTrace();
        }
    }

    /**
     * 删除学科功能
     */
    @RequestMapping("/course/deleteCourse")
    public void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            boolean deleteSuccess = courseService.deleteCourse(course);
            if (deleteSuccess) {
                JsonUtils.printResult(response, new Result(true, "删除成功"));
            } else {
                JsonUtils.printResult(response, new Result(false, "删除失败"));
            }
        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(false, "删除失败"));
            e.printStackTrace();
        }
    }

    /**
     * 查询全部的学科功能
     */
    @RequestMapping("/course/queryAllCourseName")
    public void queryAllCourseName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Course> courses = courseService.queryAllCourseName();
            if (courses != null && courses.size() > 0) {
                JsonUtils.printResult(response, new Result(true, "获取学科成功",courses));
            } else {
                JsonUtils.printResult(response, new Result(false, "获取学科失败"));
            }

        } catch (Exception e) {
            JsonUtils.printResult(response, new Result(false, "获取学科失败"));
            e.printStackTrace();
        }
    }
}
