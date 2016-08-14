package app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This override is required since war packaging was chosen to later deploy this
 * application in a web server
 * 
 * @author Rubén Jiménez Goñi
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Method that configures the application
	 * 
	 * @param application ???
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
