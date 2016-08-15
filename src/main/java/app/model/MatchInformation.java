package app.model;

/**
 * To contain information about the winner and loser of a Match
 * 
 * @author Rubén Jiménez Goñi
 */
public class MatchInformation {

	/**
	 * Player who won
	 */
	private Player winner;

	/**
	 * Player who lost
	 */
	private Player loser;

	/**
	 * Constructor that takes two players and puts them accordinly in the winner
	 * or loser position. If it is a tie A is the winner.
	 * 
	 * @param a
	 *            Player A
	 * @param b
	 *            Player B
	 */
	public MatchInformation(Player a, Player b) {
		if (b == null) {
			winner = a;
			loser = null;
		} else if (RPSHelper.evaluateStrategy(a.getStrategy(), b.getStrategy())) {
			winner = a;
			loser = b;
		} else {
			winner = b;
			loser = a;
		}
	}

	/**
	 * Method that returns the winner of the match
	 * 
	 * @return Winner
	 */
	public Player getWinner() {
		return winner;
	}

	/**
	 * Method that returns the loser of the match
	 * 
	 * @return Loser
	 */
	public Player getLoser() {
		return loser;
	}

}
