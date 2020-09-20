package io.github.mrspock182.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class LambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaApplication.class, args);
	}

}
