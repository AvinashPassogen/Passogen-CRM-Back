package country.persistence.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import country.persistence.entities.City;


public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    List<City> findCitiesByState_Id(Long stateId);

}
