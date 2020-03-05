package com.hong.mm.dao;

import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.User;
import org.apache.ibatis.annotations.Select;


/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public interface UserDao {
    @Select("select * from t_user where username=#{username}")
    User queryUser(User user);




}
