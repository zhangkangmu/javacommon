package com.hong.mm.dao;

import com.hong.mm.pojo.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/11
 */
public interface CourseDao {
    @Select("select id,icon,name title from t_course")
    List<Course> queryAllCourse() ;
}
