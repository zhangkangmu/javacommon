package hong.数据库.day02;

import hong.数据库.day01.ZYHJDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhangyuhong
 * Date:2017/12/26
 */
public class Demo {

    private static Connection connection=null;
    private static PreparedStatement preparedStatement=null;
    private static PreparedStatement preparedStatement2=null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///school", "root", "root");
            //开启事务
            connection.setAutoCommit(false);
            String sql = "update loginmessage set age =age+? where name =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 20);
            preparedStatement.setString(2, "张宇洪");
            preparedStatement.executeUpdate();

            String sql2 = "update loginmessage set age =age+? where name =?";
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.setInt(1, 100);
            preparedStatement2.setString(2, "张康木");
//             int i=3/0;
            preparedStatement2.executeUpdate();
            //提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            ZYHJDBCUtils.close(null,preparedStatement,connection);
            ZYHJDBCUtils.close(null,preparedStatement2,null);
        }
    }
}
