package com.emerald.blue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BlueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueApplication.class, args);
	}


	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
}
