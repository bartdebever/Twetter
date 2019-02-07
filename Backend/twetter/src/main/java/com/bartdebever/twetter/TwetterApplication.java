package com.bartdebever.twetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// Enables the Swagger UI.
@EnableSwagger2
public class TwetterApplication {

	/**
	 * Starts the SpringApplication on localhost:8080.
	 * @param args the arguments wanting to be given to the application.
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(TwetterApplication.class, args);
	}
}