package com.learn.greenbus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TravelAgencyDTO {
    public String id;
    public String agencyname;
    public String emailid;
    public String password;
}
