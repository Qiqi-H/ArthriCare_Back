/*
    All backend wrote by author: zhenxi zhang
    Student number: 6062027
    Date: 2023/10/20
*/
package com.example.arthricare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com/example/arthricare/mapper")
@SpringBootApplication
public class ArthriCareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArthriCareApplication.class, args);
    }

}
