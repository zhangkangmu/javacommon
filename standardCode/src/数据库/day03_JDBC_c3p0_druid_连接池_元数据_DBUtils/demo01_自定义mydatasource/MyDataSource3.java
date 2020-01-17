package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo01_自定义mydatasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 自定义连接池：
 *  规范了获取连接的方法
 *  规范了归还连接的方法
 *
 * @author liuyp
 * @date 2018/01/11
 */
public class MyDataSource3 implements DataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * 构造方法里：初始化一批连接对象，放到连接池pool里
     */
    public MyDataSource3() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < 5; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///heima", "root", "root");

            //创建connection的代理对象
            Connection connProxy = (Connection) Proxy.newProxyInstance(
                    connection.getClass().getClassLoader(),
                    connection.getClass().getInterfaces(),
                    new InvocationHandler() {
                        /**
                         * 我们每次调用代理对象的任何方法，本质执行的都是这个invoke方法
                         * @param proxy
                         * @param method
                         * @param args
                         * @return
                         * @throws Throwable
                         */
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //如果调用了代理对象的close方法：把代理对象归还到连接池
                            if ("close".equals(method.getName())) {
                                pool.addLast((Connection) proxy);
                                return null;
                            }else{
                                return method.invoke(connection, args);
                            }
                        }
                    }
            );

            //把connection的代理对象放到连接池里
            pool.add(connProxy);
        }
    }

    /**
     * 归还连接的方法
     */
    /*public void back(Connection connection) {
        pool.addLast(connection);
    }*/

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
