package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liuyp
 * @date 2018/01/11
 */
public class DemoUtilsCurdTest {
    /**
     * 查询
     */
    @Test
    public void test1() throws SQLException {
        //获取一个连接：从jdbcUtils工具类里，获取一个连接（本质是从连接池里获取的）
        Connection connection = JdbcUtils.getConnection();

        //创建预编译对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where sex = ?");
        preparedStatement.setString(1, "男");

        //执行SQL语句
        ResultSet resultSet = preparedStatement.executeQuery();

        //处理结果
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String sex = resultSet.getString("sex");
            System.out.println("username: " +username + ", sex: " + sex);
        }

        //释放资源
       JdbcUtils.close(resultSet, preparedStatement, connection);
    }

    @Test
    public void testInsert() throws Exception {
        String sql = "insert into user (id,username,password,name,birthday,age,sex) values (?,?,?,?,?,?,?)";


        Connection connection = JdbcUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, null);
        preparedStatement.setObject(2, "xiaocang");
        preparedStatement.setObject(3, "123");
        preparedStatement.setObject(4, "小仓");
        preparedStatement.setObject(5, "1989-03-21");
        preparedStatement.setObject(6, 31);
        preparedStatement.setObject(7, "女");

        int update = preparedStatement.executeUpdate();

        System.out.println("影响行数：" + update);

        JdbcUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void testUpdate() throws Exception {
        String sql = "update user set password = ? where username = ?";


        Connection connection = JdbcUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, "111");
        preparedStatement.setObject(2, "xiaocang");

        int update = preparedStatement.executeUpdate();

        System.out.println("影响行数：" + update);

        JdbcUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void testDelete() throws Exception{
        String sql = "delete from user where id = ?";


        Connection connection = JdbcUtils.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, 14);

        int update = preparedStatement.executeUpdate();

        System.out.println("影响行数：" + update);

        JdbcUtils.close(null, preparedStatement, connection);
    }
}

