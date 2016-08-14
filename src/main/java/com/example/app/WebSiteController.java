package com.example.app;

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

	public static final String INDEX_VIEW = "index";

	/**
	 * When the application
	 * 
	 * @param model
	 *            Model sent to the template
	 * @return Template to render
	 */
	@RequestMapping("/")
	public String index(Model model) {
		return INDEX_VIEW;
	}

}
