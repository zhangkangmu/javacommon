package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo01_自定义mydatasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

/**
 * 自定义连接池：基本功能实现
 *  连接池里有一个容器，容器里有一堆连接
 *
 * 仍然存在的问题：
 *  张三创建了一个连接池，获取连接的方法是：getConn
 *  李四创建了一个连接池，获取连接的方法是：getConnection
 *
 *  对于使用连接池的开发人员来说：每换一种连接池，就需要新学习一个获取连接的API---获取连接的方法 不规范
 *
 * 解决的方案：
 *  要让所有连接池里，获取连接的方法全部统一起来：Sun公司制定了一个接口java.sql.DataSource
 *  Sun公司要求，所有的连接池都必须要实现这个接口：接口里规定了获取连接的方法是getConnection
 *
 * @author liuyp
 * @date 2018/01/11
 */
public class MyDataSource1 {

    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * 构造方法里：初始化一批连接对象，放到连接池pool里
     */
    public MyDataSource1() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < 5; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
            pool.add(connection);
        }
    }

    public Connection getConn(){
        return pool.removeFirst();
    }

    public void back(Connection connection) {
        pool.addLast(connection);
    }
}
