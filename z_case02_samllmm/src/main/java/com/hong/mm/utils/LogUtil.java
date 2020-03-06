package com.hong.mm.utils;


import org.apache.log4j.Logger;


/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
    public class LogUtil {
    private static Logger logger = Logger.getLogger(LogUtil.class);
    public static void debug(String message){
        logger.debug(message);
    }
    public static void error(String message){
        logger.error(message);
        logger.error(message);
    }
}
