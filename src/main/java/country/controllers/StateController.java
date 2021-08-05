package country.controllers;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import country.persistence.entities.State;
import country.service.StateService;
import country.validator.annonation.CountryId;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("/state")
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    
    @GetMapping(value = "all")
    public Iterable<State> getAllStates(@Valid @CountryId @RequestParam Long countryId) {
    	log.info("Country id requested{}", countryId);
    	return stateService.getStatesByCountry(countryId);
    }
}
