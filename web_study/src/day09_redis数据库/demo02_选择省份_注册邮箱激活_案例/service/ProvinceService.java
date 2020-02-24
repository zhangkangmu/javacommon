package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.ProvinceDao;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.dao.impl.ProvinceDaoImpl;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.Province;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain.User;
import day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 使用redis缓存
     */

    public String queryProvince() throws JsonProcessingException {
        Jedis jedis = JedisPoolUtil.getJedis();

        String province = jedis.get("province");
        if (province == null || "".equalsIgnoreCase(province)) {
            List<Province> all = dao.findAll();
            jedis.set("province",mapper.writeValueAsString(all));
        }
        return province;
    }

}
