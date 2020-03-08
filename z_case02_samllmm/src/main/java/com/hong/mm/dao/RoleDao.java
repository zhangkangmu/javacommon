package com.hong.mm.dao;

import com.hong.mm.pojo.Role;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/8
 */
public interface RoleDao {
    List<Role> getUserRole(Integer id) ;
}
