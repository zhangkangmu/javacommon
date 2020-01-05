package hong.数据库.day01;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zhangyuhong
 * Date:2017/12/25
 */
public class ZYHJDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            ClassLoader classLoader = ZYHJDBCUtils.class.getClassLoader();
            URL resource = classLoader.getResource("hong/myjdbc.properties");
            String path = resource.getPath();
            Properties properties = new Properties();
            properties.load(new FileReader(path));

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }




    public static void close(Statement statement, Connection connection) {
        close(null,statement,connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
