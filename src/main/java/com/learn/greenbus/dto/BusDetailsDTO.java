package com.learn.greenbus.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusDetailsDTO {
    public String id;
    public String busNumber;
    public String agencyid;
    public int seatCount;
    public String type;
    public boolean ac;
    public List<String> seatNumber = new ArrayList<String>();

}
