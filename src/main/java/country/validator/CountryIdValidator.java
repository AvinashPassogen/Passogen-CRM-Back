package country.validator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import country.persistence.entities.Country;
import country.service.CountryService;
import country.validator.annonation.CountryId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Slf4j
public class CountryIdValidator implements ConstraintValidator<CountryId, Long> {

	 @Autowired
	    private CountryService countryService;

	    @Override
	    public boolean isValid(Long countryId, ConstraintValidatorContext constraintValidatorContext) {
	        final Optional<Country> country = countryService.findCountryById(countryId);
	        log.info("Country for {} found {}", countryId, country.isPresent());
	        return country.isPresent();
	    }
}
