package com.hsm.seungsime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SeungSimEApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeungSimEApplication.class, args);
    }

}
