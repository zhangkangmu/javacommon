package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo01_自定义mydatasource;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author liuyp
 * @date 2020/01/11
 */
public class MyDataSourceTest {
    /**
     * 测试连接池：基本功能版本
     */
    @Test
    public void test1() throws Exception {
        //创建连接池对象：里边有一堆 连接
        MyDataSource1 dataSource1 = new MyDataSource1();

        //要获取一个连接对象：从连接池里获取一个
        Connection conn = dataSource1.getConn();

        //创建预编译对象
        PreparedStatement preparedStatement = conn.prepareStatement("select * from user");
        //执行SQL语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //处理结果
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }

        //释放资源
        resultSet.close();
        preparedStatement.close();
        //conn.close();
        dataSource1.back(conn);
    }

    /**
     * 规定了获取连接方法的连接池
     */
    @Test
    public void test2() throws Exception {
        MyDataSource2 dataSource2 = new MyDataSource2();

        Connection connection = dataSource2.getConnection();
        System.out.println(connection);

        //归还连接的方法要统一起来。我们习惯性 用完Connection，就把Connection给close()掉
        //dataSource2.back(connection);
        //我们期望的效果是：close()方法的作用是 归还到连接池，而不是销毁连接
        /**
         * 我们需要对Connection的close方法，进行功能增强/修改
         *  装饰者模式：创建Connection对象的包装类，在包装类修改close功能代码
         *  动态代理：生成Connection对象的代理对象，在代理对象里修改close功能代码
         *  创建子类，继承父类：不方便。因为MySql驱动包里Connection实现类 和Oracle驱动包里Connection实现类不同
         */
        connection.close();
    }

    @Test
    public void test3() throws Exception {
        MyDataSource3 dataSource3 = new MyDataSource3();

        Connection connection = dataSource3.getConnection();
        System.out.println(connection);

        //归还连接的方法要统一起来。我们习惯性 用完Connection，就把Connection给close()掉
        //dataSource2.back(connection);
        //我们期望的效果是：close()方法的作用是 归还到连接池，而不是销毁连接
        /**
         * 我们需要对Connection的close方法，进行功能增强/修改
         *  装饰者模式：创建Connection对象的包装类，在包装类修改close功能代码
         *  动态代理：生成Connection对象的代理对象，在代理对象里修改close功能代码
         *  创建子类，继承父类：不方便。因为MySql驱动包里Connection实现类 和Oracle驱动包里Connection实现类不同
         */
        connection.close();
    }


    /**
     * 连接池的性能测试
     */
    @Test
    public void test() throws Exception {
        //不用连接池：创建2000个Connection对象，花费的时间
        Class.forName("com.mysql.jdbc.Driver");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
            connection.close();
        }
        long end = System.currentTimeMillis();

        System.out.println("JDBC创建2000个连接，用时：" + (end - start));

        System.out.println("----------------------------");

        //使用连接池，获取2000个Connection对象，花费的时间
        MyDataSource1 dataSource1 = new MyDataSource1();
        start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            Connection conn = dataSource1.getConn();
            dataSource1.back(conn);
        }
        end = System.currentTimeMillis();

        System.out.println("连接池获取2000个连接，用时：" + (end - start));
    }
}
