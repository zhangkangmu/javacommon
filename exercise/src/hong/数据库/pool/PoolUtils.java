package hong.数据库.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 */
public class PoolUtils {

    private static DataSource dataSource;
    private static Connection connection;


    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = PoolUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {
        close(connection, preparedStatement, null);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
