package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.library.entity" })
//@EnableJpaRepositories(basePackages = "com.library.entity")
public class LibrabryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrabryManagementSystemApplication.class, args);
	}
}

