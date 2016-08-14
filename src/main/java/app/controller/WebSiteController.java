package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles all the requests coming from the user navigating the web site
 * 
 * @author Rubén Jiménez Goñi
 */
@Controller
public class WebSiteController {

	public static final String HOME_VIEW = "home";
	public static final String HELP_VIEW = "help";
	public static final String RANKING_VIEW = "ranking";
	public static final String ABOUT_VIEW = "about";
	public static final String DOCUMENTATION_VIEW = "documentation";
	public static final String ADMINISTRATION_VIEW = "administration";

	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/")
	public String home(Model model) {
		return HOME_VIEW;
	}
	
	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/help")
	public String help(Model model) {
		return HELP_VIEW;
	}

	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/ranking")
	public String ranking(Model model) {
		return RANKING_VIEW;
	}

	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/about")
	public String about(Model model) {
		return ABOUT_VIEW;
	}

	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/documentation")
	public String documentation(Model model) {
		return DOCUMENTATION_VIEW;
	}

	/**
	 * When the application ???
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/administration")
	public String administration(Model model) {
		return ADMINISTRATION_VIEW;
	}

}
