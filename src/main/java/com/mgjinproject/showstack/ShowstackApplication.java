package com.mgjinproject.showstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShowstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowstackApplication.class, args);
	}

}
