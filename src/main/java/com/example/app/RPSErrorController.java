package com.example.app;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RPSErrorController implements ErrorController {

	public static final String ERROR_VIEW = "error";

	@RequestMapping("/error")
	public String index(Model model) {
		return ERROR_VIEW;
	}

	@Override
	public String getErrorPath() {
		return ERROR_VIEW;
	}

}
