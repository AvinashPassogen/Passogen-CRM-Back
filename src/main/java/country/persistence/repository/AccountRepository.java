package country.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import country.persistence.entities.Account;
import country.persistence.entities.Contacts;

public interface AccountRepository extends JpaRepository<Account, Long> {


	public Account findByEmail(String email);


	List<Account> findByNameContaining(String name);


}
