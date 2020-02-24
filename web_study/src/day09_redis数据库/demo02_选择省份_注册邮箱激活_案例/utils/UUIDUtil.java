package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.utils;

import java.util.UUID;

/**
 * UUID是一种生成随机字符串的算法。
 * 会生成：32位长字符串，每个字符是随机的一个十六进制字符
 * 总共可以生成：16的32次方个随机字符串
 */
public class UUIDUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
