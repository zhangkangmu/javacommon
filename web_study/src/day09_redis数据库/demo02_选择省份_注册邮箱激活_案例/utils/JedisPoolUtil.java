package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
public class JedisPoolUtil {
    private static JedisPool pool;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(bundle.getString("maxIdle")));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(bundle.getString("maxTotal")));
        pool = new JedisPool(jedisPoolConfig, bundle.getString("host"), Integer.parseInt(bundle.getString("port")));
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
