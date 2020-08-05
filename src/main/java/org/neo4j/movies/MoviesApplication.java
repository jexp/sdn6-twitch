package org.neo4j.movies;

import org.neo4j.driver.Driver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(MovieService service) {
		return args ->
				System.out.printf("Hello graph world (%d movie nodes)%n",service.nodeCount("Movie"));
	}
}
