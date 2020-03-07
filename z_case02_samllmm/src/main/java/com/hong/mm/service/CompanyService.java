package com.hong.mm.service;

import com.hong.mm.dao.CompanyDao;
import com.hong.mm.pojo.Company;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public class CompanyService {
    public List<Company> addQuestionQueryCompany() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CompanyDao mapper = sqlSession.getMapper(CompanyDao.class);
       List<Company> companys=mapper.addQuestionQueryCompany();
//        for (Company company : companys) {
//            System.out.println(company);
//        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return companys;
    }
}
