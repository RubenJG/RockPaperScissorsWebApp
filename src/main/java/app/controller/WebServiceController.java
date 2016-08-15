package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.database.DBPlayer;
import app.database.DBPlayerRepository;
import app.model.MatchInformation;
import app.model.RPSHelper;
import app.model.Winner;

/**
 * Controller meant to handle requests for the web services available
 * 
 * @author Rubén Jiménez Goñi
 */
@RestController
@RequestMapping("api/championship")
public class WebServiceController {

	private static long WINNER_POINTS = 3;
	private static long LOSER_POINTS = 1;

	@Autowired
	private DBPlayerRepository repository;

	/**
	 * Method that handles POSTS requests made to be /api/championship/new path
	 * 
	 * @param championshipDefinition
	 *            Definition of the championship to be processed
	 * @return Json object containing information about the winner
	 * @throws Exception
	 *             if the championship is malformed
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public Winner computeWinner(@RequestParam(value = "data", required = true) String championshipDefinition)
			throws Exception {

		MatchInformation info = RPSHelper.getWinner(championshipDefinition);
		processPlayer(info.getWinner().getName(), WINNER_POINTS);
		processPlayer(info.getLoser().getName(), LOSER_POINTS);

		return new Winner(info.getWinner());
	}

	private void processPlayer(String name, long score) {
		DBPlayer player = null;
		List<DBPlayer> list = repository.findByName(name);
		if( list != null && list.size() > 0 ) {
			player = list.get(0);
		} else {
			player = new DBPlayer(name, 0);
		}
		player.increaseScore(score);
		repository.save(player);
		
	}

}
