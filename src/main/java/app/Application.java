package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application's entry class.
 * 
 * @author Rubén Jiménez Goñi
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
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
