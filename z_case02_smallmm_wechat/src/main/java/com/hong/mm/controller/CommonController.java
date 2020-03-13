package com.hong.mm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hong.mm.pojo.Course;
import com.hong.mm.pojo.Dict;
import com.hong.mm.service.CommonService;
import com.hong.mm.service.CourseService;
import com.hong.mm.utils.JsonUtils;
import com.hong.mm.utils.WxUtil;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/3/10
 */
@Controller
public class CommonController {
    private CommonService commonService = new CommonService();
    private CourseService courseService=new CourseService();

    @RequestMapping("/common/cities")
    public void loadCities(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap map = JsonUtils.parseJSON2Object(request, HashMap.class);
        if (map != null) {
            Map cityMessage = commonService.getCityMessage(map);
            System.out.println(cityMessage);
            if (cityMessage.size() > 0) {
                JsonUtils.printResult(response, cityMessage);
            }
        }
    }
    @RequestMapping("/common/courses")
    public void loadCourses(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String  courseList = courseService.getCourses();
            if (!"".equalsIgnoreCase(courseList)){
                JsonUtils.printResult(response, JSON.parse(courseList));
            }else {
                JsonUtils.printResult(response, null);
            }
    }

}
