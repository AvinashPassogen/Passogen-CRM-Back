package country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import country.persistence.entities.City;
import country.persistence.repository.CityRepository;


@Service
public class CityService {

	private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Cacheable(value = "getCitiesByState", key = "#stateId")
    public Iterable<City> getCitiesByState(Long stateId) {
        return cityRepository.findCitiesByState_Id(stateId);
    }

}
