package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo07_第三方dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util.JdbcUtils;

import java.sql.SQLException;

/**
 * DBUtils执行DML语句
 * @author liuyp
 * @date 2018/01/11
 */
public class Demo01DbUtilsDml {

    //创建QueryRunner对象
    private QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    /**
     * 执行删除语句
     */
    @Test
    public void test1() throws SQLException {
        //执行SQL语句
        int update = runner.update("delete from user where username = ?", "xiaocang");

        System.out.println("影响行数：" + update);
    }
}
