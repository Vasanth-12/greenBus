package com.learn.greenbus.dto;

import java.util.List;

import com.learn.greenbus.model.SeatInfo;
import com.learn.greenbus.validation.SeatValidation;

import lombok.Builder;

@Builder
public class BookingDTO {
    public String id;
    public String journeyId;

    @SeatValidation
    public List<SeatInfo> seatInfo;
}
