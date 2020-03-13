package com.hong.mm.service;

import com.alibaba.druid.util.DruidDataSourceUtils;
import com.hong.mm.dao.CourseDao;
import com.hong.mm.dao.DictDao;
import com.hong.mm.pojo.Course;
import com.hong.mm.pojo.Dict;
import com.hong.mm.utils.LocationUtil;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyuhong
 * Date:2020/3/10
 */
public class CommonService {
    public Map getCityMessage(HashMap map) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        DictDao dictDao = sqlSession.getMapper(DictDao.class);
//        这里有问题,试试传两个参数的
        //获取经纬坐标获取的
        String location = LocationUtil.parseLocation((String) map.get("location"));
        System.out.println("根据坐标解析出来的地址是:"+location);
        Dict dict=dictDao.getCityLocationName(location);
        System.out.println("数据中读取的城市:"+dict);

        //获取其他可以选择的城市
        Integer fs = (Integer) map.get("fs");
        List<Dict> dictList=dictDao.getCanSelectName(fs);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("location",dict);
        hashMap.put("citys",dictList);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return hashMap;
    }
}
