package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.Opportunity;

public interface OppoRepo extends JpaRepository<Opportunity, Long> {

	List<Opportunity> findByOpportunityContaining(String opportunity);


}
