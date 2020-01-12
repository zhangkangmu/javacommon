package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo05_metadata元数据;


import 数据库.day01_JDBC基础_增删改查_api_事务.demo04_封装util.JdbcUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

/**
 * ParameterMetaData元数据：preparedStatement预编译对象提供了获取的方法
 * @author liuyp
 * @date 2020/01/11
 */
public class Demo01ParameterMetaData {

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = JdbcUtils.getConnection();
        //创建预编译对象
        String sql = "select * from user where age > ? and sex = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        //获取ParameterMetaData对象
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        //获取预编译SQL中，占位符?的个数
        int parameterCount = parameterMetaData.getParameterCount();
        System.out.println("预编译的SQL中，占位符?的个数：" + parameterCount);

        //获取第1个参数的类型
        int parameterType = parameterMetaData.getParameterType(1);
        System.out.println("获取第1个占位符？的类型：" + parameterType);


        //释放资源
        preparedStatement.close();
        connection.close();
    }
}
