package app.webservice;

import app.model.Player;

/**
 * Class meant to create winner object returned as json by the webservice
 * 
 * @author Rubén Jiménez Goñi
 */
public class WinnerResponse {

	/**
	 * String array that holds the winner's name and strategy
	 */
	private String winner[];

	/**
	 * Constructor that builds a winner from a Player object
	 * 
	 * @param p
	 *            Player that won the championship
	 */
	public WinnerResponse(Player p) {
		winner = new String[] { p.getName(), p.getStrategy() };
	}

	/**
	 * Returns the array containing the winner's information
	 * 
	 * @return Array containing the winner's information
	 */
	public String[] getWinner() {
		return winner;
	}
}
