package com.example.mobilelele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearNotInFutureValidator implements ConstraintValidator<YearNotInFuture, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        } else {

            int currYear = Year.now().getValue();

            return value.intValue() <= currYear;
        }
    }
}