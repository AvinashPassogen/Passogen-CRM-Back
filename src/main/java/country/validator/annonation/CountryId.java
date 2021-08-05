package country.validator.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import country.validator.CountryIdValidator;


@Constraint(validatedBy = {CountryIdValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryId {

	String message() default "Invalid Country Id value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
