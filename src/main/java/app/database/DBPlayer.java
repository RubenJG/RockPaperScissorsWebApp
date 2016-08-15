package app.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DBPlayer {

	/**
	 * Id of the player
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Name of the player
	 */
	@Column(unique = true)
	private String name;

	/**
	 * Score of the player
	 */
	private long score;

	protected DBPlayer() {
	}

	public DBPlayer(String name, long score) {
		this.name = name;
		this.score = score;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getScore() {
		return score;
	}

	public void increaseScore(long toSum) {
		score += toSum;
	}

}
