package com.mine.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xujie
 */
@SpringBootApplication
@MapperScan("com.mine.manager.mapper")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
