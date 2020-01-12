package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo06_mydbutils_自定义QueryRunner;


import 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util.JdbcUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author liuyp
 * @date 2020/01/11
 */
public class MyQueryRunner {

    public void update(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        int parameterCount = parameterMetaData.getParameterCount();
        for (int i = 0; i < parameterCount; i++) {
            preparedStatement.setObject(i+1, params[i]);
        }

        int update = preparedStatement.executeUpdate();

        System.out.println("影响行数：" + update);

        JdbcUtils.close(null, preparedStatement, connection);
    }
}
