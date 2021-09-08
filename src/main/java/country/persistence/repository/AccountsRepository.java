package country.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import country.persistence.entities.Account;

public interface AccountsRepository extends CrudRepository<Account, Long> {

	@Query(value = "SELECT count(id) FROM Account")
	public long count();
}
