package com.study;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(scanBasePackages = {"com.study.service"})
@MapperScan("com.study.mapper")
public class UserCenterProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterProduceApplication.class, args);
    }

}
