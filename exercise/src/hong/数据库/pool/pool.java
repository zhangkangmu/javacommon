package hong.数据库.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 * 阿里的叫Druid
 */
public class pool {
    public static void main(String[] args) {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("otherc3p0");
        try {
            Connection connection = comboPooledDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from stdent");
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
