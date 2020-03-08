package com.hong.mm.service;

import com.hong.mm.dao.PermissionDao;
import com.hong.mm.dao.RoleDao;
import com.hong.mm.dao.UserDao;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.pojo.Permission;
import com.hong.mm.pojo.Role;
import com.hong.mm.pojo.User;
import com.hong.mm.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/4
 */
public class UserService {
    public User login(User loginUser) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        List<String> authorityList = new ArrayList<>();
        //获取用户的基本信息
        User user = userMapper.queryUser(loginUser);

        //获取用户的权限
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        PermissionDao permissionDao = sqlSession.getMapper(PermissionDao.class);
        //1.获取用户的角色
        if (user != null && user.getId() != null) {

            List<Role> roleList = roleDao.getUserRole(user.getId());
            //因为一个用户可能含有多个角色,所以要遍历
            for (Role role : roleList) {
                authorityList.add(role.getKeyword());
                //2.获取用户的角色里的权限
                List<Permission> userPermission = permissionDao.getUserPermission(role.getId());
                //一个用户有多个权限
                for (Permission permission : userPermission) {
                    authorityList.add(permission.getKeyword());
                }
            }
            for (String userAu : authorityList) {
                System.out.println(user.getUsername()+"的权限有:"+userAu);
            }
            user.setAuthorityList(authorityList);
        }

        //一定要注意啊!!!关流   执行方法在前面
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return user;
    }

}
