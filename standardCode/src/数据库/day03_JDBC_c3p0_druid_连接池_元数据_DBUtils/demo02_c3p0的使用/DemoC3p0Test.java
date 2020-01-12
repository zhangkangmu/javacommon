package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo02_c3p0的使用;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * c3p0连接池使用示例
 * @author liuyp
 * @date 2020/01/11
 */
public class DemoC3p0Test {

    /**
     * c3p0连接池的常用方式
     */
    @Test
    public void test1() throws SQLException {
        //1. 创建连接池对象：c3p0会自动读取src下的c3p0-config.xml，初始化一批连接。无参构造加载的是默认配置
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //2. 从连接池里获取连接：方法一定是getConnection()
        Connection connection = dataSource.getConnection();

        //3. 使用连接，操作数据库
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }

        //4. 释放资源：连接对象需要归还到连接池，一定是close()方法
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    /**
     * c3p0连接池：使用命名配置
     */
    @Test
    public void test2() throws SQLException {
        //1.创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource("heima3");
        //2.获取连接
        Connection connection = dataSource.getConnection();

        //3.操作数据库
        PreparedStatement preparedStatement = connection.prepareStatement("select * from orders");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String money = resultSet.getString("money");
            System.out.println(money);
        }

        //4.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    /**
     * 硬编码方式的c3p0（目前用的少，Spring框架里会用）
     * 手动set配置信息等
     */
    @Test
    public void test3() throws Exception {
        //1. 创建连接池对象：如果没有c3p0-config.xml，也没问题。我们只要使用硬编码方式，设置连接池信息即可
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///heima");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        //2. 获取连接
        Connection connection = dataSource.getConnection();

        //3. 使用连接，操作数据库
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }

        //4. 释放资源：连接对象需要归还到连接池，一定是close()方法
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
