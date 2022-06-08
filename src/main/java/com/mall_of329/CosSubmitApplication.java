package com.mall_of329;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@MapperScan("com.mall_of329.dao")
//@ComponentScan("com.mall_of329")
public class CosSubmitApplication {
    public static void main(String[] args) {
        SpringApplication.run(CosSubmitApplication.class, args);
    }

}
