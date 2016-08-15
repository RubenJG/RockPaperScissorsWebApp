package app.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DBPlayerRepository extends CrudRepository<DBPlayer, Long> {

	List<DBPlayer> findByName(String name);

}
