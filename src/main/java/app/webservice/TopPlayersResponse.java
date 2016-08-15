package app.webservice;

import java.util.List;

/**
 * Class meant to create objects that will be serialize as json in order to be
 * returned by the web service
 * 
 * @author Rubén Jiménez Goñi
 */
public class TopPlayersResponse {

	/**
	 * List of highest scoring players
	 */
	private List<String> players;

	/**
	 * Allows to create a response sending the list of players
	 * 
	 * @param players
	 *            List of players
	 */
	public TopPlayersResponse(List<String> players) {
		this.players = players;
	}

	/**
	 * Returns the list of players
	 * 
	 * @return List of players
	 */
	public List<String> getPlayers() {
		return players;
	}

}
