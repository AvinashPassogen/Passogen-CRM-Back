package country.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import country.persistence.entities.Contacts;

public interface ContactRepository extends CrudRepository<Contacts, Long> {

	@Query(value = "SELECT count(id) FROM Contacts")
	public long count();
}
