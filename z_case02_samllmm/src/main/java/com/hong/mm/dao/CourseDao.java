package com.hong.mm.dao;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Course;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public interface CourseDao {
    List<Course> getPageList(QueryPageBean queryPageBean);

    Long getAllCount(QueryPageBean pageBean);
}
