package country.persistence.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import country.persistence.entities.State;

public interface StateRepository extends PagingAndSortingRepository<State, Long> {

    List<State> findStatesByCountry_Id(Long countryId);

}
