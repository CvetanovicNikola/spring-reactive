package com.example.springReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
	}

	@Bean
	ConnectionFactoryInitializer initializer(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
	  ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
	  initializer.setConnectionFactory(connectionFactory);
	  ResourceDatabasePopulator resource =
	      new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
	  initializer.setDatabasePopulator(resource);
	  return initializer;
	}

}
