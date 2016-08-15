package app.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.database.DBPlayer;
import app.database.DBPlayerRepository;
import app.model.MatchInformation;
import app.model.RPSHelper;
import app.webservice.StatusResponse;
import app.webservice.TopPlayersResponse;
import app.webservice.WinnerResponse;

/**
 * Controller meant to handle requests for the web services available
 * 
 * @author Rubén Jiménez Goñi
 */
@RestController
@RequestMapping("api/championship")
public class WebServiceController {

	/**
	 * Amount of points earned by players when they win
	 */
	private static long WINNER_POINTS = 3;

	/**
	 * Amount of points earned by players when they lose
	 */
	private static long LOSER_POINTS = 1;

	/**
	 * Repository of DBPlayer objects
	 */
	@Autowired
	private DBPlayerRepository repository;

	/**
	 * Allow creating queries
	 */
	@Autowired
	private EntityManager em;

	/**
	 * Method that handles POST requests made to the /api/championship/result
	 * path Allows to record the results of a tournament
	 * 
	 * @param first
	 *            Player that won
	 * @param second
	 *            Player that lost
	 * @return status = success if everything went the right way
	 */
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public StatusResponse saveResult(@RequestParam(value = "first", required = true) String first,
			@RequestParam(value = "second", required = true) String second) {
		processPlayer(first, WINNER_POINTS);
		processPlayer(second, LOSER_POINTS);
		return new StatusResponse("success");
	}

	/**
	 * Method that handles POST requests made to the api/championship/top path
	 * Allows to see the top players, but not their scores
	 * 
	 * @param count
	 * @return
	 */
	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public TopPlayersResponse getTop(@RequestParam(value = "count", required = false, defaultValue = "10") int count) {
		List<String> names = em.createQuery("select name from DBPlayer order by score desc", String.class).setMaxResults(10)
				.getResultList();
		return new TopPlayersResponse(names);

	}

	/**
	 * Method that handles POST requests made to be /api/championship/new path
	 * 
	 * @param championshipDefinition
	 *            Definition of the championship to be processed
	 * @return Json object containing information about the winner
	 * @throws Exception
	 *             if the championship is malformed
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public WinnerResponse computeWinner(@RequestParam(value = "data", required = true) String championshipDefinition)
			throws Exception {

		MatchInformation info = RPSHelper.getWinner(championshipDefinition);
		processPlayer(info.getWinner().getName(), WINNER_POINTS);
		processPlayer(info.getLoser().getName(), LOSER_POINTS);

		return new WinnerResponse(info.getWinner());
	}

	/**
	 * Saves player information to the db. If it exists it updates the player,
	 * otherwise it creates the player
	 * 
	 * @param name
	 *            Name of the player
	 * @param score
	 *            Score to add to the player
	 */
	private void processPlayer(String name, long score) {
		DBPlayer player = null;
		List<DBPlayer> list = repository.findByName(name);
		if (list != null && list.size() > 0) {
			player = list.get(0);
		} else {
			player = new DBPlayer(name, 0);
		}
		player.increaseScore(score);
		repository.save(player);

	}

}
