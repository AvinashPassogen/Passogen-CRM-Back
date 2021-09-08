package country.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import country.persistence.entities.State;
import country.service.StateService;
import country.validator.annonation.StateId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateIdValidator implements ConstraintValidator<StateId, Long> {

	 private final StateService stateService;

	    public StateIdValidator(StateService stateService) {
	        this.stateService = stateService;
	    }

	    @Override
	    public boolean isValid(Long stateId, ConstraintValidatorContext constraintValidatorContext) {
	        final Optional<State> stateOptional = stateService.findStateById(stateId);
	        log.info("State for {} found {}", stateId, stateOptional.isPresent());
	        return stateOptional.isPresent();
	    }
}
