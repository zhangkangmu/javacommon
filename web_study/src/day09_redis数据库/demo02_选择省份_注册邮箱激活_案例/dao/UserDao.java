package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao;

import day00_utils.DruidJDBCUtils;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
public class UserDao {
    QueryRunner query = new QueryRunner(DruidJDBCUtils.getDataSource());

    public int register(User user) throws SQLException {
        String sql = "insert into user (username,password,email,sex) values(?,?,?,?)";
        return query.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getSex());
    }

    public int active(String username) throws SQLException {
        String sql = "UPDATE USER SET STATUS='Y' WHERE username=?";
        return query.update(sql, username);
    }
}
