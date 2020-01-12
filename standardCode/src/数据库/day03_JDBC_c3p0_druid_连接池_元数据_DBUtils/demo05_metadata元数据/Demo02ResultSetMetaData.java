package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo05_metadata元数据;


import 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo04_C3P0Util.JdbcUtils;

import java.sql.*;

/**
 * ResultSetMetaData元数据：从resultSet里获取的
 * @author liuyp
 * @date 2020/01/11
 */
public class Demo02ResultSetMetaData {

    public static void main(String[] args) throws SQLException {
        //获取连接
        Connection connection = JdbcUtils.getConnection();
        //创建预编译对象
        PreparedStatement preparedStatement = connection.prepareStatement("select id,username uname from user");
        //执行SQL语句
        ResultSet resultSet = preparedStatement.executeQuery();

        //获取ResultSetMetaData
        ResultSetMetaData metaData = resultSet.getMetaData();

        //获取查询结果集里，列的个数
        int columnCount = metaData.getColumnCount();
        System.out.println("查询结果集里列数：" + columnCount);

        //获取第1列的名称、类型、别名
        String columnName1 = metaData.getColumnName(1);
        String columnLabel1 = metaData.getColumnLabel(1);
        int columnType1 = metaData.getColumnType(1);
        System.out.println("第1列名称：" + columnName1 + ", 类型：" + columnType1 + "，别名：" + columnLabel1);

        //获取第2列的名称、类型、别名
        String columnName2 = metaData.getColumnName(2);
        String columnLabel2 = metaData.getColumnLabel(2);
        int columnType2 = metaData.getColumnType(2);
        System.out.println("第2列名称：" + columnName2 + ", 类型：" + columnType2 + "，别名：" + columnLabel2);


        //释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
