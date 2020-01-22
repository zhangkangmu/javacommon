package day00_utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author liuyp
 * @date 2018/01/11
 */
public class C3P0JdbcUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement, Connection connection){
        close(null, statement, connection);
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        // inn 生成 if not null ,  ifn 生成 if null
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
