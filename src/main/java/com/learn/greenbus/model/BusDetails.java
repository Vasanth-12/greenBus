package com.learn.greenbus.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "BusDetails")
public class BusDetails {
    
    @Id
    public String id;
    public String busNumber;
    public String agencyid;
    public int seatCount;
    public String type;
    public boolean ac;
    public List<String> seatNumber = new ArrayList<>();

    // WIP
    /*
     * Need be add Created, LastModified, Deleted
     * 
     */

}
