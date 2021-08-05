package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String userName);

	User getUserByUsername(String username);

}
