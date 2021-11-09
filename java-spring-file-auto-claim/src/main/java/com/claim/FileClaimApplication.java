package com.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.claim", exclude = { SecurityAutoConfiguration.class})
public class FileClaimApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FileClaimApplication.class, args);
	}
}
