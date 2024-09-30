package com.learn.greenbus.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BusDetailsDTO {
    public String id;
    public String agencyid;
    public String type;
    public boolean ac;

}
