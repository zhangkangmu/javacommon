package com.hong.mm.dao;

import com.hong.mm.pojo.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public interface TagDao {
    @Select("SELECT id,NAME FROM t_tag where course_id=#{courseId} ")
    Tag getQueryQuestionTagByCourseId(int courseId);

    int saveQuestionTag(Map<String, Integer> question_tag_map);
}