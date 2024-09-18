package com.learn.greenbus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JourneyDTO {
    public String id;
    public int ticketFee;
    public int availableSeats;
    public BusDetailsDTO busDetailsDTO;

}
