package com.learn.greenbus.model;

import java.sql.Timestamp;
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
    public Timestamp startingTimeStamp;
    public Timestamp endingTimestamp;
    public List<String> boardingPoints;
    public List<Timestamp> boardingPointTimestamps;
    public int availableSeats;
    public BusDetails busdetails;
    public HashMap<String, BookingDetails> seatDetails = new HashMap<String, BookingDetails>();


}
