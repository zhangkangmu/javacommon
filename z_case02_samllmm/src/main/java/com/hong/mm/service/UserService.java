package com.hong.mm.service;

import com.hong.mm.dao.UserDao;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.User;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public class UserService {
    public User login(User loginUser) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.queryUser(loginUser);
//       一定要注意啊!!!关流   执行方法在前面
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return user;
    }

}
