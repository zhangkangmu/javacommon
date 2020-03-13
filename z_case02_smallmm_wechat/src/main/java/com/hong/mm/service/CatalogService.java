package com.hong.mm.service;

import com.hong.mm.dao.CatalogDao;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/13
 */
public class CatalogService {

    public List getList(HashMap listMap) throws IOException {
        List<HashMap<String, Object>> list=null;
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        //todo    等下做的功能--判断种类kind
        Integer categoryKind = (Integer) listMap.get("categoryKind");
        if (categoryKind == 1) {
            //按照技术点划分
            CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
            list = catalogDao.getList(listMap);
            System.out.println(list);
        }else if (categoryKind == 2){
            //按照企业划分
        }else {
            //按照方向划分
        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }

    public HashMap findWxMember(String openid) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao catalogDao = sqlSession.getMapper(CatalogDao.class);
        HashMap wxMemberHashMap = catalogDao.findWxMember(openid);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return wxMemberHashMap;
    }
}
