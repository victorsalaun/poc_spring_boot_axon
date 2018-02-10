package com.victorsalaun.pocspringaxon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.victorsalaun.pocspringaxon.query.person")
public class PocSpringAxonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringAxonApplication.class, args);
	}

}
