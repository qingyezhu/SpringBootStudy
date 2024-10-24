package com.wangzhu.springboot.config;

import com.wangzhu.springboot.interceptor.HelloInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wangz on 2024/9/12 15:44.
 **/
@Configuration
public class HelloConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HelloInterceptor interceptor = new HelloInterceptor();
        registry.addInterceptor(interceptor).addPathPatterns("/*");
    }
}
