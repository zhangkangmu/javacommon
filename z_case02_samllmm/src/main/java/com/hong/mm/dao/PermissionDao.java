package com.hong.mm.dao;

import com.hong.mm.pojo.Permission;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/8
 */
public interface PermissionDao {
    List<Permission>getUserPermission(int roleId);
}
