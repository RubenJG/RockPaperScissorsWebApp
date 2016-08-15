package app.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface that is automatically implemented by JPA in order to access the
 * database in an easy way
 * 
 * @author Rubén Jiménez Goñi
 */
public interface DBPlayerRepository extends CrudRepository<DBPlayer, Long> {

	/**
	 * Allows to find players by their name
	 * 
	 * @param name
	 *            Name of the player to find
	 * @return List of players found. It should consist of 1 player maximum.
	 */
	List<DBPlayer> findByName(String name);

}
