package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.RPSHelper;
import app.model.Winner;

@RestController
@RequestMapping("api/championship")
public class WebServiceController {

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public Winner computeWinner(@RequestParam(value = "data", required = true) String data) throws Exception {
		return RPSHelper.getWinner(data);
	}

}
