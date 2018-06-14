package com.upvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
public class UpvoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpvoteApplication.class, args);
	}
}
