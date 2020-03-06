package com.hong.mm.service;

import com.hong.mm.dao.QuestionDao;
import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Question;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public class QuestionService {
    public PageResult getQuestionList(QueryPageBean pageBean) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
        List<Question> questionList = questionDao.getQuestionList(pageBean);
        Long allQuestion = questionDao.getAllQuestion(pageBean);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return new PageResult(allQuestion,questionList);
    }
}
