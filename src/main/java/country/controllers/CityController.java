package country.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.City;
import country.service.CityService;
import country.validator.annonation.StateId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/city")
public class CityController {

	private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "all")
    public Iterable<City> getAllStates(@Valid @StateId @RequestParam Long stateId) {
        log.info("StateId id requested {}", stateId);
        return cityService.getCitiesByState(stateId);
    }
}
