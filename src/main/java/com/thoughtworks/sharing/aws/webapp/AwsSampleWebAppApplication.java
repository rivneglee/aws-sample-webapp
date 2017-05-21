package com.thoughtworks.sharing.aws.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AwsSampleWebAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AwsSampleWebAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsSampleWebAppApplication.class, args);
	}
}
