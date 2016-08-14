package app.model;

public class RPSHelper {

	private static final String ROCK = "R";
	private static final String PAPER = "P";
	private static final String SCISSORS = "S";

	/**
	 * Method that takes a championship definition and evaluates it to find the winner
	 *
	 * @param championship 
	 * @return
	 * @throws Exception If the championship definition is malformed
	 */
	public static Winner getWinner(String championship) throws Exception {
		championship = championship.trim();
		championship = championship.replaceAll("\\s+", "");
		return new Winner(executeChampionship(championship));
	}

	/**
	 * This recursive method evaluates the championship definition in order to
	 * find the tournament's winner. If something goes wrong, it will throw an
	 * exception.
	 * 
	 * The recursive strategy tries to find the left and right side of the top
	 * level array, it isolates both members of this array and then it continues
	 * to do the same with the arrays found. When an array can't be divided it
	 * means it should be a player. The method always returns the current winner
	 * of the branch being evaluated.
	 * 
	 * @param current
	 *            Current string being evaluated
	 * @return The player that won the current branch
	 * @throws Exception
	 *             If the string is malformed or if a player tries to use an
	 *             unvalid strategy
	 */
	private static Player executeChampionship(String current) throws Exception {

		// Removing start and end characters
		current = current.substring(1, current.length() - 1);

		// Winner of the current championship branch
		Player winner = null;

		// Start and end characters of the current branch
		char startChar = current.charAt(0);
		char endChar = current.charAt(current.length() - 1);

		if (startChar == '[' && endChar == ']') {

			// There's more data below
			// Find the middle point
			int middle = 0;
			int ignore = 0;
			boolean found = false;
			while (middle < current.length() && !found) {
				char currentChar = current.charAt(middle);
				switch (currentChar) {
				case '[':
					++ignore;
					break;
				case ']':
					--ignore;
					break;
				case ',':
					if (ignore == 0) {
						found = true;
					}
					break;
				default:
					break;
				}
				if (!found) {
					++middle;
				}
			}

			String leftBranch = current.substring(0, middle);
			String rightBranch = current.substring(middle + 1, current.length());

			Player leftPlayer = executeChampionship(leftBranch);
			Player rightPlayer = executeChampionship(rightBranch);

			winner = evaluatePlayer(leftPlayer, rightPlayer);

		} else if (startChar == '\"' && endChar == '\"') {

			// This is a player
			String playerData[] = current.split("\",\"");
			if (playerData.length != 2) {
				throw new Exception("The championship definition is malformed");
			}

			playerData[0] = playerData[0].substring(1, playerData[0].length());
			playerData[1] = playerData[1].substring(0, playerData[1].length() - 1);
			
			// All strategies are converted to uppercase
			
			playerData[1] = playerData[1].toUpperCase();

			if (!validateStrategy(playerData[1])) {
				throw new Exception("A player is using an unvalid strategy");
			}
			winner = new Player(playerData[0], playerData[1]);

		} else {
			throw new Exception("The championship definition is malformed");
		}
		return winner;
	}

	/**
	 * Method that validates that a players strategy is valid in Rock Paper
	 * Scissors
	 * 
	 * @param strategy
	 *            Strategy that the player wants to use
	 * @return true if the strategy is valid
	 */
	private static boolean validateStrategy(String strategy) {
		return strategy.equals(ROCK) || strategy.equals(PAPER) || strategy.equals(SCISSORS);
	}

	/**
	 * Method that evaluates two players and returns the player with the winner
	 * strategy
	 * 
	 * @param a
	 *            Player A
	 * @param b
	 *            Player B
	 * @return the winner player or player A if it is a tie
	 */
	private static Player evaluatePlayer(Player a, Player b) {
		Player winner = a;
		if (evaluateStrategy(b.getStrategy(), a.getStrategy())) {
			winner = b;
		}
		return winner;
	}

	/**
	 * Method that evaluates the strategies of two players
	 * 
	 * @param strategyA
	 *            Strategy of player A
	 * @param strategyB
	 *            Strategy of player B
	 * @return true only if strategyA defeats strategyB
	 */
	private static boolean evaluateStrategy(String strategyA, String strategyB) {
		return strategyA.equals(ROCK) && strategyB.equals(SCISSORS)
				|| strategyA.equals(SCISSORS) && strategyB.equals(PAPER)
				|| strategyA.equals(PAPER) && strategyB.equals(ROCK);
	}

}
