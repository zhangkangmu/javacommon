package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao;


import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.Province;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface ProvinceDao {

    public List<Province> findAll() ;

}
