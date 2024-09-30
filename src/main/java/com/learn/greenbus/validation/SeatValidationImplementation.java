package com.learn.greenbus.validation;

import java.util.List;

import com.learn.greenbus.model.SeatInfo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SeatValidationImplementation implements ConstraintValidator<SeatValidation, List<SeatInfo>> {

    @Override
    public boolean isValid(List<SeatInfo> seatInfo, ConstraintValidatorContext constraintValidatorContext) {
        return seatInfo.size() <= 2;
    }
}
