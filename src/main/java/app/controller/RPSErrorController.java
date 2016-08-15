package app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller meant to handle any errors in the requests made by the user
 * 
 * @author Rubén Jiménez Goñi
 */
@Controller
public class RPSErrorController implements ErrorController {

	/**
	 * Error template
	 */
	public static final String ERROR_VIEW = "error";

	/**
	 * Method that handles when the user asks for the /error path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/error")
	public String error(Model model) {
		return ERROR_VIEW;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getErrorPath() {
		return ERROR_VIEW;
	}
}
