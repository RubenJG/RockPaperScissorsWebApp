package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller meant to handle requests made by the user when navigating the
 * application
 * 
 * @author Rubén Jiménez Goñi
 */
@Controller
public class WebSiteController {

	/**
	 * Home template
	 */
	public static final String HOME_VIEW = "home";

	/**
	 * Help template
	 */
	public static final String HELP_VIEW = "help";

	/**
	 * Ranking template
	 */
	public static final String RANKING_VIEW = "ranking";

	/**
	 * About template
	 */
	public static final String ABOUT_VIEW = "about";

	/**
	 * Documentation template
	 */
	public static final String DOCUMENTATION_VIEW = "documentation";

	/**
	 * Administration template
	 */
	public static final String ADMINISTRATION_VIEW = "administration";

	/**
	 * Method that handles when the user asks for the / path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/")
	public String home(Model model) {
		return HOME_VIEW;
	}

	/**
	 * Method that handles when the user asks for the /help path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/help")
	public String help(Model model) {
		return HELP_VIEW;
	}

	/**
	 * Method that handles when the user asks for the /ranking path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/ranking")
	public String ranking(Model model) {
		return RANKING_VIEW;
	}

	/**
	 * Method that handles when the user asks for the /about path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/about")
	public String about(Model model) {
		return ABOUT_VIEW;
	}

	/**
	 * Method that handles when the user asks for the /documentation path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/documentation")
	public String documentation(Model model) {
		return DOCUMENTATION_VIEW;
	}

	/**
	 * Method that handles when the user asks for the /administration path
	 * 
	 * @param model
	 *            Model that contains variables sent to the template
	 * @return the template that should be rendered
	 */
	@RequestMapping("/administration")
	public String administration(Model model) {
		return ADMINISTRATION_VIEW;
	}

}
