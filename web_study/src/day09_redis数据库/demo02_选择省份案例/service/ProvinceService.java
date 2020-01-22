package day09_redis数据库.demo02_选择省份案例.service;

import day09_redis数据库.demo02_选择省份案例.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();
}
