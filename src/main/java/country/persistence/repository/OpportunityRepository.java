package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import country.persistence.entities.Opportunity;

public interface OpportunityRepository extends CrudRepository<Opportunity, Long> {

	

	@Query(value = "SELECT t FROM Opportunity t where t.close_date = CURRENT_DATE")
	List<Opportunity> allOppo();
}
