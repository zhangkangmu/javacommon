package 数据库.day03_JDBC_c3p0_druid_连接池_元数据_DBUtils.demo06_mydbutils_自定义QueryRunner;

import org.junit.Test;

/**
 * @author liuyp
 * @date 2020/01/11
 */
public class DemoCurdTest2 {

    private MyQueryRunner runner = new MyQueryRunner();

    @Test
    public void testInsert() throws Exception {
        String sql = "insert into user (id,username,password,name,birthday,age,sex) values (?,?,?,?,?,?,?)";
        Object[] params = {null,"xiaocang","123","小仓","1989-03-21",31,"女"};

        runner.update(sql, params);
    }

    @Test
    public void testUpdate() throws Exception {
        runner.update("update user set password = ? where username = ?", "111", "xiaocang");
    }

    @Test
    public void testDelete() throws Exception{
        runner.update("delete from user where id = ?", 16);
    }
}

