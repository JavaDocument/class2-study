package com.practice.jefeel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class JefeelApplication {

	public static void main(String[] args) {
		SpringApplication.run(JefeelApplication.class, args);
	}

}
