package br.com.via.poc.plataformas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
