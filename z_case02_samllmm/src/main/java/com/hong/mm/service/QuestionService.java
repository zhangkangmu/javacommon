package com.hong.mm.service;

import com.hong.mm.dao.QuestionDao;
import com.hong.mm.dao.QuestionItemDao;
import com.hong.mm.dao.TagDao;
import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Question;
import com.hong.mm.pojo.QuestionItem;
import com.hong.mm.pojo.Tag;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return new PageResult(allQuestion, questionList);
    }

    public boolean saveQuestion(Question question) throws IOException {
        int count = 0;
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        //1.问题题干信息
        QuestionDao questionDao = sqlSession.getMapper(QuestionDao.class);
        //2.问题列表
        QuestionItemDao questionItemDao = sqlSession.getMapper(QuestionItemDao.class);
        List<QuestionItem> questionItemList = question.getQuestionItemList();
        //3.标签列表
        List<Tag> tagList = question.getTagList();
        Map<String, Integer> question_tag_map = new HashMap<>();

        //id为0说明是新增学科,其他的为修改学科
        if (question.getId() == 0) {
            //1.保存问题题干信息
            count = questionDao.saveQuestion(question);
            if (count>0){
                System.out.println("保存题干信息成功");
            }
            //新增加的题目id
            Integer questionId = question.getId();
            //2.保存问题列表
            if (questionItemList != null && questionItemList.size() > 0) {
                //客户端提交的有题目选项信息，需要挨个保存到数据库t_question_item表,因为没一个表的一行都有一是一个选项
                for (QuestionItem questionItem : questionItemList) {
                    questionItem.setQuestionId(questionId);
                    //如果选项里有内容，说明是有效的选项；否则是无效选项（用户没有录入这一项数据），不需要保存
                    String content = questionItem.getContent();
                    if (!"".equalsIgnoreCase(content) && content!=null){
                        int itemCount = questionItemDao.saveQuestionItem(questionItem);
                        if (itemCount>0){
                            System.out.println("保存选项成功");
                        }
                    }
                }
            }
            System.out.println(question);
            //3.保存标签
            TagDao tagDao = sqlSession.getMapper(TagDao.class);
            question_tag_map.put("questionId",questionId);
            for (Tag tag : tagList) {
                question_tag_map.put("tagId",tag.getId());
                int tagCount = tagDao.saveQuestionTag(question_tag_map);
                if (tagCount>0){
                    System.out.println("保存标签成功");
                }
            }
        } else {
            //todo    等下做的功能--修改试题
        }
        //注意,提交事务和关闭的代码可以直接写在这里,插入id也可以获取
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return count > 0;
    }
}
