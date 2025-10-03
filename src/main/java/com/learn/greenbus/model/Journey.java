package com.learn.greenbus.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Journey")
public class Journey {

    @Id
    public String id;
    public String startingPoint;
    public String destination;
    public Date startingTimeStamp;
    public Date endingTimestamp;
    public List<String> boardingPoints;
    public List<Date> boardingPointTimestamps;
    public int availableSeats;
    public int ticketFee;
    public BusDetails busdetails;
    public HashMap<String, SeatInfo> seatDetails = new HashMap<>();
}