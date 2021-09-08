package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.User;

public interface RegistrationRepository extends JpaRepository<User, Long> {

	public User findByEmail(String userEmail);

	public User findByUsername(String username);



}
