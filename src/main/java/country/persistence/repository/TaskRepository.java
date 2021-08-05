package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.task;

public interface TaskRepository extends JpaRepository<task, Long> {

	List<task> findBySubjectContaining(String subject);

}
