package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo03_druid德鲁伊使用;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Druid连接池使用示例
 * @author liuyp
 * @date 2020/01/11
 */
public class DemoDruidTest {

    /**
     * druid连接池：基本使用
     */
    @Test
    public void test1() throws Exception {
        InputStream is = DemoDruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);


        //1.创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //2.从连接池里获取连接
        Connection connection = dataSource.getConnection();
        //3.操作数据库
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }
        //4.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close(); //归还到连接池了

        is.close();
    }

    /**
     * druid：硬编码使用方式（目前使用的少，Spring框架里会用到，了解）
     */
    @Test
    public void test2() throws Exception{
        //1. 创建连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///heima");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2.从连接池里获取连接
        Connection connection = dataSource.getConnection();
        //3.操作数据库
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }
        //4.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close(); //归还到连接池了
    }
}
