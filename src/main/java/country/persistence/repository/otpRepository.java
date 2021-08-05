package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.OtPassword;


public interface otpRepository extends JpaRepository<OtPassword, Long> {


	OtPassword findByEmail(String email);


}
