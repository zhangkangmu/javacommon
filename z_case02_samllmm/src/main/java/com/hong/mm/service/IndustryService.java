package com.hong.mm.service;

import com.hong.mm.dao.IndustryDao;
import com.hong.mm.pojo.Industry;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public class IndustryService {
    public List<Industry> addQuestionQueryIndustry() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        IndustryDao mapper = sqlSession.getMapper(IndustryDao.class);
        List<Industry> industries = mapper.addQuestionQueryIndustry();
        return industries;
    }
}
