package com.mall_of329.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huangRong
 * @date 2021/11/1 23:49
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //本应用的所有方法都会去处理跨域请求
        registry.addMapping("/**")
                //允许远端访问的域名
                .allowedOrigins("http://127.0.0.1:8081")
                //允许请求的方法("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedMethods("*")
                //允许请求头
                .allowedHeaders("*");
    }
}