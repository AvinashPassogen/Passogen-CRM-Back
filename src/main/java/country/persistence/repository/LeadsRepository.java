package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import country.persistence.entities.Leads;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, Long> {

	List<Leads> findByTitleContaining(String title);

	public Leads findByEmail(String email);

}
