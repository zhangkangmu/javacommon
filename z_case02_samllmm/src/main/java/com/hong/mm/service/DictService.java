package com.hong.mm.service;

import com.hong.mm.dao.DictDao;
import com.hong.mm.pojo.Dict;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public class DictService {
    public List<Dict> addQuestionQueryDict() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        DictDao mapper = sqlSession.getMapper(DictDao.class);
        List<Dict> dicts=mapper.addQuestionQueryDict();
        for (Dict dict : dicts) {
            System.out.println(dict);
        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return dicts;
    }
}
