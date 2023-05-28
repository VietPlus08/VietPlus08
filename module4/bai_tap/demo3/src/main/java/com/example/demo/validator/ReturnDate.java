package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ReturnDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ReturnDate {
    String message() default "Not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
