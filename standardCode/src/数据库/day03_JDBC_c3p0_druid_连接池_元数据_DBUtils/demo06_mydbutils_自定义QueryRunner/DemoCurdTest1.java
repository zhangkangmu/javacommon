package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo06_mydbutils_自定义QueryRunner;

import org.junit.Test;
import 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util.JdbcUtils;

import java.sql.*;

/**
 * @author liuyp
 * @date 2018/01/11
 */
public class DemoCurdTest1 {

    @Test
    public void testInsert() throws Exception {
        String sql = "insert into user (id,username,password,name,birthday,age,sex) values (?,?,?,?,?,?,?)";
        Object[] params = {null,"xiaocang","123","小仓","1989-03-21",31,"女"};


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

    @Test
    public void testUpdate() throws Exception {
        String sql = "update user set password = ? where username = ?";
        Object[] params = {"111", "xiaocang"};

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

    @Test
    public void testDelete() throws Exception{
        String sql = "delete from user where id = ?";
        Object[] params = {15};


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

