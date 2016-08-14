package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application's entry class.
 * 
 * @author Rubén Jiménez Goñi
 */
@SpringBootApplication
public class Application {

	/**
	 * Application's entry method
	 * 
	 * @param args Arguments sent to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
