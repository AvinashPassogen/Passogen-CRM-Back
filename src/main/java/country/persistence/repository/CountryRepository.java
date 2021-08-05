package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
