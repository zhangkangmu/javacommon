package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo07_第三方dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * DBUtils执行查询
 * @author liuyp
 * @date 2018/01/11
 */
public class Demo02DbUtilsDql {
    private QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
    /**
     * 查询一条数据，得到一个JavaBean对象：
     * 查询id为10的用户，得到一个User对象
     */
    @Test
    public void test1() throws SQLException {
        User user = runner.query("select * from user where id = ?", new BeanHandler<>(User.class), 10);

        System.out.println(user);
    }

    /**
     * 查询多条数据，得到一个JavaBean集合：
     * 查询所有用户，得到List<User>
     */
    @Test
    public void test2() throws SQLException {
        List<User> userList = runner.query("select * from user", new BeanListHandler<>(User.class));
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 查询一条数据，得到一个Map。通常是多表关联查询时使用
     * 查询id为10的用户
     */
    @Test
    public void test3() throws SQLException {
        Map<String, Object> map = runner.query("select * from user where id = ?", new MapHandler(), 10);

        System.out.println(map);
    }

    /**
     * 查询所有用户，得到List<Map>。通常是多表关联查询时使用
     */
    @Test
    public void test4() throws SQLException {
        List<Map<String, Object>> mapList = runner.query("select * from user", new MapListHandler());

        for (Map<String, Object> map : mapList) {
            System.out.println(map);
        }
    }

    /**
     * 查询数量
     */
    @Test
    public void test5() throws SQLException {
        Long query = (Long) runner.query("select count(*) from user", new ScalarHandler());

        System.out.println("user表里的数量：" + query);
    }
}
