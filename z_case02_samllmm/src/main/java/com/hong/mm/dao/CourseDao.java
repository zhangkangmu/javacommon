package com.hong.mm.dao;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public interface CourseDao {
    List<Course> getPageList(QueryPageBean queryPageBean);

    /**
     * 辅助getPageList获取全部(有可能包含搜索条件)的查询列表
     */
    Long getAllCount(QueryPageBean pageBean);

    /**
     * 增加科目
     */
    int addCourse(Course course);

    @Update("UPDATE t_course SET NAME =#{name} WHERE id=#{id}")
    int updataCourse(Course course);

    @Delete("DELETE FROM t_course WHERE id=#{id}")
    int deleteCourse(Course course);


    @Select("SELECT id,NAME FROM t_course")
    List<Course> queryAllCourseName();

    /**
     * 增加题目的时候需要查询的学科列表
     */
    List<Course> addQuestionQueryCourse();

}
