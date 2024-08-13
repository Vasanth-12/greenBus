package com.learn.greenbus.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value="prototype")
public class BookingDetails {
    public String busId;
    public String seatNumber;
    public String passengerName;
    public int passengerAge;
    public boolean booked;
    public String boardingPoint;
    public String dropingPoint;
    
}
