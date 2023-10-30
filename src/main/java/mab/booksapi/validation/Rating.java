package mab.booksapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class Rating implements ConstraintValidator<RatingConstraint, Double> {
    Double[] validValues = { 1.0, 1.5, 2.0, 2.5, 3.0,
                            3.5, 4.0, 4.5, 5.0};
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return List.of(validValues).contains(value);
    }
}
