package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {

	List<Contacts> findByEmail(String email);

	public Contacts findByemail(String email);

	List<Contacts> findByAccountContaining(String account);

}
