package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * Created by zhangyuhong
 * Date:2020/2/13
 */
public class JdbcUtil {
    private static ComboPooledDataSource pool = new ComboPooledDataSource();

    public static DataSource getDataSource() {
        return pool;
    }
}
