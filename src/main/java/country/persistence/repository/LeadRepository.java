package country.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import country.persistence.entities.Leads;

@Repository
public interface LeadRepository extends CrudRepository<Leads, Long> {

	@Query(value = "SELECT count(id) FROM Leads")
	public long count();
}
