package com.hong.mm.dao;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Question;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public interface QuestionDao {

    List<Question> getQuestionList(QueryPageBean pageBean);

    Long getAllQuestion(QueryPageBean pageBean);
}
