package com.hong;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by zhangyuhong
 * Date:2020/6/18
 */
@Configuration
public class ServletContextConfig {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");  //对来自/** 这个链接来的请求进行拦截
    }
}
