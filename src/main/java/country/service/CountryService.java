package country.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import country.persistence.entities.Country;
import country.persistence.repository.CountryRepository;


@Service
public class CountryService {

	private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Cacheable(value = "findCountryById", key = "#countryId")
    public Optional<Country> findCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Cacheable(value = "getCountries")
    public Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }

	
}
