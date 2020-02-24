package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.impl;


import day00_utils.DruidJDBCUtils;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.ProvinceDao;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.Province;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 jdbctemplement
    QueryRunner query=new QueryRunner(DruidJDBCUtils.getDataSource());
//    private JdbcTemplate template = new JdbcTemplate(DruidJDBCUtils.getDataSource());

    @Override
    public List<Province> findAll()  {

        //1.定义sql
        String sql = "select * from province ";
        //2.执行sql
//        List<Province> list = query.query(sql, new BeanHandler<Province>(Province.class));
        List<Province> list = null;
        try {
            list = query.query(sql,new BeanListHandler<>(Province.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


}
