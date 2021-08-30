package country.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import country.persistence.entities.task;

public interface TasksRepository extends CrudRepository<task, Long> {

	@Query(value = "SELECT count(id) FROM task t where t.date2 = CURRENT_DATE")
	public long count();

	@Query(value = "SELECT count(id) FROM task")
	public long countAll();
}
