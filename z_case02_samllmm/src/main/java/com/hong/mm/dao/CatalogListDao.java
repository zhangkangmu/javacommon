package com.hong.mm.dao;

import com.hong.mm.pojo.Catalog;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
public interface CatalogListDao {
    @Select("select id,name from t_catalog where  course_id=#{courseId}")
    Catalog getQueryCatalogListByCourseId(int courseId);
}
