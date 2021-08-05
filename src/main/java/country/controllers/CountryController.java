package country.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.Country;
import country.service.CountryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/country")
public class CountryController {

	private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "all")
    public Iterable<Country> getAllCountries() {
        return countryService.getCountries();
    }
	
}
