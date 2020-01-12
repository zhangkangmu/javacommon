package 数据库.day02_JDBC_C3P0_druid连接池datasource_JDBCTemplate.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import 数据库.day02_JDBC_C3P0_druid连接池datasource_JDBCTemplate.utils.JDBCUtils;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
