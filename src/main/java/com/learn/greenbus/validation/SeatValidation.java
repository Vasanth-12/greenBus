package com.learn.greenbus.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Constraint(validatedBy=SeatValidationImplementation.class)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface SeatValidation {

    public String message() default "Booking seat exceeds max threshold";

    Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
