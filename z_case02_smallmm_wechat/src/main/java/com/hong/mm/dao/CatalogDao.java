package com.hong.mm.dao;

import com.hong.mm.entity.QuestionList;
import com.hong.mm.pojo.Catalog;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/13
 */
public interface CatalogDao {
     List<HashMap<String,Object>> getList(HashMap listMap) ;

     HashMap findWxMember(String openid);
}
