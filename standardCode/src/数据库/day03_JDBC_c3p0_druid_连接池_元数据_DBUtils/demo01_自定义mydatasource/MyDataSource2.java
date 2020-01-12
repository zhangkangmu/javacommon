package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo01_自定义mydatasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 自定义连接池：规范了获取连接的方法
 *  要让所有连接池里，获取连接的方法全部统一起来：Sun公司制定了一个接口javax.sql.DataSource
 *  Sun公司要求，所有的连接池都必须要实现这个接口：接口里规定了获取连接的方法是getConnection
 *
 * 存在的问题：
 *  归还连接到连接池  的方法，名称不统一，不规范
 *
 * @author liuyp
 * @date 2020/01/11
 */
public class MyDataSource2 implements DataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * 构造方法里：初始化一批连接对象，放到连接池pool里
     */
    public MyDataSource2() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < 5; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");
            pool.add(connection);
        }
    }

    /**
     * 归还连接的方法
     */
    public void back(Connection connection) {
        pool.addLast(connection);
    }

    /**
     * 获取连接的方法
     */
    @Override
    public Connection getConnection() throws SQLException {
        return pool.removeFirst();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
