package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;
import java.time.LocalDate;

public class ReturnDateValidator implements ConstraintValidator<ReturnDate, Date> {

    @Override
    public void initialize(ReturnDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null){
            return false;
        }
        Date currentDate = Date.valueOf(LocalDate.now());
        return date.after(currentDate);
    }
}
