package dao;

import domain.Contact;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/18
 */
public class SearchKeyWordDao {
    private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

    public List<Contact> searchKeyWord(String username) throws SQLException {
        String sql = "select * from user where username LIKE ?";
        return runner.query(sql, new BeanListHandler<>(Contact.class), "%" + username + "%");
    }
}
