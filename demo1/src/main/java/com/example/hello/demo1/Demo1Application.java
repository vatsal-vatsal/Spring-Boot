package com.example.hello.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Spring Boot Application Class
 * 
 * This is the entry point of our Spring Boot application.
 * Spring Boot automatically configures and runs the application from this class.
 * 
 * @SpringBootApplication - Combines three annotations:
 *   1. @Configuration: Marks class as configuration class
 *   2. @EnableAutoConfiguration: Enables Spring Boot's auto-configuration
 *   3. @ComponentScan: Enables component scanning for @Component, @Service, @Controller, etc.
 * 
 * @EnableJpaRepositories - Enables Spring Data JPA repositories
 *   This tells Spring to scan for interfaces extending JpaRepository
 *   and automatically create implementations for database operations.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Demo1Application {

	/**
	 * Main method - Application entry point
	 * 
	 * @param args Command line arguments passed to the application
	 * SpringApplication.run() starts the Spring Boot application:
	 *   - Creates the application context
	 *   - Scans for components and configurations
	 *   - Starts the embedded web server (Tomcat)
	 *   - Wires up all dependencies
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
