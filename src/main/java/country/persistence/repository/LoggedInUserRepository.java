package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.LoggedInUser;

public interface LoggedInUserRepository extends JpaRepository<LoggedInUser, Long> {

}
