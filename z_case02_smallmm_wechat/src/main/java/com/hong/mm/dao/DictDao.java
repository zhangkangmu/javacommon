package com.hong.mm.dao;

import com.hong.mm.pojo.Dict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/10
 */
public interface DictDao {
    @Select("SELECT id,data_value title from t_dict WHERE data_value LIKE CONCAT('%',#{locationName},'%')")
    Dict getCityLocationName(String location);

    @Select("select id, data_value title from t_dict where data_type = 1 and data_tag = #{dataTag}")
    List<Dict> getCanSelectName(Integer fs);
}
