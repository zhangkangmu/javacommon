package com.hong.mm.service;

import com.hong.mm.dao.MemberDao;
import com.hong.mm.pojo.WxMember;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhangyuhong
 * Date:2020/3/12
 */
public class MemberService {

    public WxMember findMemberByOpenId(String openid) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
        WxMember memberByOpenId = memberDao.findMemberByOpenId(openid);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return memberByOpenId;
    }

    public boolean saveWxMember(WxMember wxMember) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
        int i = memberDao.saveWxMember(wxMember);
        System.out.println("i的值" + i);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return i > 0;
    }

    public boolean saveWxMemberCityCourse(HashMap map) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
        int i = memberDao.saveCityCourse(map);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return i > 0;
    }
}
