package com.practice.lkdcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LkdcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LkdcodeApplication.class, args);
    }

}
