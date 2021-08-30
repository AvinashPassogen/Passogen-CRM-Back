package country.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import country.persistence.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

}
