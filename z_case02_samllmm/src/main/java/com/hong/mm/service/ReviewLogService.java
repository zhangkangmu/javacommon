package com.hong.mm.service;

import com.hong.mm.constants.Constants;
import com.hong.mm.dao.QuestionDao;
import com.hong.mm.dao.ReviewLogDao;
import com.hong.mm.pojo.Question;
import com.hong.mm.pojo.ReviewLog;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public class ReviewLogService {
    public boolean reviewQuestion(ReviewLog reviewLog) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        ReviewLogDao reviewLogDao = sqlSession.getMapper(ReviewLogDao.class);
        int reviewLogCount=reviewLogDao.addReviewLog(reviewLog);
        if (reviewLogCount>0){
            System.out.println("审核通过,问题id:"+reviewLog.getQuestionId());
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("questionId", reviewLog.getQuestionId());
        //准备数据,去改变题目的状态--  t_question表里的数据
//        审核状态
        if (reviewLog.getStatus()== Constants.QUESTION_REVIEWED){
//            已审核
            hashMap.put("is_classic",1);
            hashMap.put("status",Constants.QUESTION_PUBLISHED);
            hashMap.put("review_status",Constants.QUESTION_REVIEWED);

        }else if (reviewLog.getStatus()==Constants.QUESTION_REJECT_REVIEW) {
//        已拒绝
            hashMap.put("is_classic", 0);
            hashMap.put("status", Constants.QUESTION_PRE_PUBLISH);
            hashMap.put("review_status", Constants.QUESTION_REJECT_REVIEW);
        }

        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
       int updateCount= questionDao.updateQuestionReview(hashMap);
       if (updateCount>0){
           System.out.println("修改题目审核状态成功");
       }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return reviewLogCount>0 && updateCount>0;
    }
}
