package com.practice.lkdcode;

import com.practice.lkdcode.global.config.jwt.JWTProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(JWTProperties.class)
public class LkdcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LkdcodeApplication.class, args);
    }

}
