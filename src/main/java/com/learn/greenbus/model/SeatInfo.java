package com.learn.greenbus.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Data
@Component
@Scope("prototype")
@Builder
public class SeatInfo {
    public String seatNumber;
    public String passengerName;
    public int passengerAge;
    public boolean booked;
    public String boardingPoint;
    public String destination;
}
