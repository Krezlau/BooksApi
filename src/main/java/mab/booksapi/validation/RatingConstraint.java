package mab.booksapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Rating.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RatingConstraint {
    String message() default "Rating invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
