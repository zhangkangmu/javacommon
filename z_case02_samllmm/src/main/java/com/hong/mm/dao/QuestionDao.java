package com.hong.mm.dao;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public interface QuestionDao {

    List<Question> getQuestionList(QueryPageBean pageBean);

    Long getAllQuestion(QueryPageBean pageBean);


    /**
     * @param question 前端传来封装好的数据
     * @return 保存后影响的行数
     */
    int saveQuestion(Question question);

    int updateQuestionReview(HashMap<String, Integer> hashMap);
}
