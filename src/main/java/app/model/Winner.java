package app.model;

public class Winner {

	private String winner[];

	public Winner(Player p) {
		winner = new String[] { p.getName(), p.getStrategy() };
	}

	public Winner(String winner[]) {
		this.winner = winner;
	}

	public String[] getWinner() {
		return winner;
	}
}
