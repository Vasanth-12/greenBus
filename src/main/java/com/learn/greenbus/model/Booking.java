package com.learn.greenbus.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "Booking")
public class Booking {

    @Id
    public String id;
    public String journeyid;
    public List<SeatInfo> seatInfo;
}
