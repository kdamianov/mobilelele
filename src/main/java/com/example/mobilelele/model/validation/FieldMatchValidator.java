package com.example.mobilelele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstField;
    private String secondField;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.first();
        this.secondField = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        //инициализираме този клас, за може анотацията да се ползва на различни обекти
        BeanWrapper beanWrapper = PropertyAccessorFactory
                .forBeanPropertyAccess(value);

        Object firstProperty = beanWrapper.getPropertyValue(this.firstField);
        Object secondProperty = beanWrapper.getPropertyValue(this.secondField);

        boolean isValid = Objects.equals(firstProperty, secondProperty);

        if (!isValid) {
            context
                    .buildConstraintViolationWithTemplate(this.message) //показва съобщението при невалидни данни.
                    .addPropertyNode(this.secondField)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
