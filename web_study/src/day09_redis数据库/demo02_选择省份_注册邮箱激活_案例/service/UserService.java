package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.service;

import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.UserDao;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;

import java.sql.SQLException;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
public class UserService {
    private UserDao dao = new UserDao();

    public boolean register(User user) throws SQLException {
       return dao.register(user)>0;

    }

    public boolean active(String username) throws SQLException {
        return dao.active(username)>0;
    }
}
