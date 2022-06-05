package com.mall_of329;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@MapperScan("com/example/cossubmit/mapper")
public class CosSubmitApplication {
    public static void main(String[] args) {
        SpringApplication.run(CosSubmitApplication.class, args);
    }

}
