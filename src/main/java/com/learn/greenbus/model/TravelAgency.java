package com.learn.greenbus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "TravelAgency")
public class TravelAgency {

    @Id
    public String id;
    public String agencyname;
    public String emailid;
    public String password;

    /*
     * Need to add Created, Lastmodified, deleted 
     */

}
