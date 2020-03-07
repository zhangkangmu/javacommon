package com.hong.mm.dao;

import com.hong.mm.pojo.Industry;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public interface IndustryDao {
    /**
     * 查询企业的时候执行的方法,获取想关联的行业
     */
    List<Industry> addQuestionQueryCompany2Industry(int industryID);

    @Select("select * from t_industry")
    List<Industry> addQuestionQueryIndustry();
}
