package com.example.mobilelele.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)                         //анотацията ще е валидна по време на runtime
@Target(ElementType.FIELD)                                  //указва къде може да се приложи анотацията
@Constraint(validatedBy =YearNotInFutureValidator.class)    //указваме кой ще е класът, който валидира полето
public @interface YearNotInFuture {                         //слага се @interface, тк ще е анотация

    String message() default "Year should not be in the future!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
