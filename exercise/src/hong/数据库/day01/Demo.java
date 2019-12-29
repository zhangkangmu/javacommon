package hong.数据库.day01;

import java.sql.*;

/**
 * Created by zhangyuhong
 * Date:2019/12/23
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //注册驱动包
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
        //update(connection);
        //insertData(connection);
        Statement statement = connection.createStatement();
        String sql="select * from students";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.println(id+"--"+name+"--"+age);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }

    /**
     * 修改数据
     * @param connection
     * @throws SQLException
     */
    private static void insertData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql="insert into students value (null,'张三',18)";
        int count = statement.executeUpdate(sql);
        System.out.println("影响了"+count+"行");
        statement.close();
        connection.close();
    }

    /**
     * 更新数据
     * @param connection
     * @throws SQLException
     */
    private static void update(Connection connection) throws SQLException {
        String sql = "UPDATE students SET age=25 WHERE id=1;";
        //创建sql对象
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println(count);
        statement.close();
        connection.close();
    }
}
