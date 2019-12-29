package hong.数据库.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhangyuhong
 * Date:2019/12/26
 * 阿里的叫Druid
 */
public class DruidPool {

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
//        insert();
//        search();
    }


    private static void search() {
        Connection connection = PoolUtils.getConnection();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(PoolUtils.getDataSource());
        String sql = "select * from students";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Student student : query) {
            System.out.println(student);
        }

//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from students");
//        for (Map<String, Object> map : maps) {
//            System.out.println(map);
//        }


//        String sql = "select * from  students  where id = ? or id = ?";
//        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1, 2);
//        System.out.println(stringObjectMap);

    }

    private static void insert() {
        Connection connection = PoolUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            String sql = "insert into students value (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "hong");
            preparedStatement.setInt(3, 100);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.executeQuery();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PoolUtils.close(connection, preparedStatement, resultSet);
        }
    }


}
