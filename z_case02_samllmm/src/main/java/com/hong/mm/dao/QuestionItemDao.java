package com.hong.mm.dao;

import com.hong.mm.pojo.QuestionItem;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public interface QuestionItemDao {
    /**
     * 功能:保存新增试题选项
     * @param questionItemList 客户端请求携带的问题列表参数
     * @return
     */
     int saveQuestionItem(QuestionItem questionItemList);
}
