package country.persistence.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import country.persistence.entities.Leads;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, Long> {


	public Leads findByEmail(String email);

	List<Leads> findByCompanyContaining(String company);

}
