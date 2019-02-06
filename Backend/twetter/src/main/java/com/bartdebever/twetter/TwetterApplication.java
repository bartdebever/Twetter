package com.bartdebever.twetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class , SecurityAutoConfiguration.class})
@EnableSwagger2
public class TwetterApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TwetterApplication.class, args);
	}
}