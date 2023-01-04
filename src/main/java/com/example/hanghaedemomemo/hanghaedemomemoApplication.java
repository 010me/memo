package com.example.hanghaedemomemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class hanghaedemomemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(hanghaedemomemoApplication.class, args);
	}

}
