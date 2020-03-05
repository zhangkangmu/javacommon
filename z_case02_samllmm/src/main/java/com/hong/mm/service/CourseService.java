package com.hong.mm.service;

import com.hong.mm.dao.CourseDao;
import com.hong.mm.dao.UserDao;
import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Course;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public class CourseService {
    public  PageResult getPageList(QueryPageBean pageBean) throws IOException {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        CourseDao mapper = session.getMapper(CourseDao.class);
        List<Course> pageList = mapper.getPageList(pageBean);
        Long allCount = mapper.getAllCount(pageBean);
        SqlSessionFactoryUtils.commitAndClose(session);
        return new PageResult(allCount,pageList);
    }
}
