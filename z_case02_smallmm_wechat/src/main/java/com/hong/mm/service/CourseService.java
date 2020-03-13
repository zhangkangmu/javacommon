package com.hong.mm.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hong.mm.dao.CourseDao;
import com.hong.mm.pojo.Course;
import com.hong.mm.utils.JedisUtils;
import com.hong.mm.utils.JsonUtils;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/11
 */
public class CourseService {

    public String getCourses() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        List<Course> courseList;
        Jedis jedis = JedisUtils.getJedis();
        String courseListJson = jedis.get("courseList");
        if (courseListJson == null || "".equalsIgnoreCase(courseListJson)) {
            //说明没有缓存
            courseList = courseDao.queryAllCourse();
            if (courseList != null) {
                //说明成功从数据库中获取的值
                jedis.set("courseList", JSON.toJSONString(courseList));
                courseListJson=JSON.toJSONString(courseList);
            }
        }
        JedisUtils.close(jedis);

        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return courseListJson;
    }
}
