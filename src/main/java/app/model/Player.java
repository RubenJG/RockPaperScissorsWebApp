package app.model;

/**
 * Models a player in the championship
 * 
 * @author Rubén Jiménez Goñi
 */
public class Player {

	/**
	 * Name of the player
	 */
	private String name;
	
	/**
	 * Strategy of the player
	 */
	private String strategy;

	/**
	 * Constructor that builds a player object from a name and strategy
	 * 
	 * @param name Name of the player
	 * @param strategy Current strategy of the player
	 */
	public Player(String name, String strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	/**
	 * Returns the name of the player
	 * 
	 * @return Name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the strategy of the player
	 * 
	 * @return Current strategy of the player
	 */
	public String getStrategy() {
		return strategy;
	}

}
