package com.wang.springbootloginregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wang.springbootloginregister.mapper")
@SpringBootApplication
public class SpringbootLoginRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginRegisterApplication.class, args);
    }

}
