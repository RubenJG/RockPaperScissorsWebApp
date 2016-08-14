package app.model;

public class Player {

	private String name;
	private String strategy;

	public Player(String name, String strategy) {
		this.name = name;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public String getStrategy() {
		return strategy;
	}

}
