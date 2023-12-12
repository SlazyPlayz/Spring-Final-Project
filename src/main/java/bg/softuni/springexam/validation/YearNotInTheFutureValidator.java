package bg.softuni.springexam.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearNotInTheFutureValidator implements ConstraintValidator<YearNotInTheFuture, Number> {
    @Override
    public void initialize(YearNotInTheFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        int currentYear = Year.now().getValue();

        return value.intValue() <= currentYear;
    }
}
