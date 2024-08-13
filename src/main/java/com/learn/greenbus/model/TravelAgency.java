package com.learn.greenbus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "TravelAgency")
public class TravelAgency {

    @Id
    public String id;
    public String agencyName;
    public String agencyEmailID;
    public String password;

    /*
     * Need to add Created, Lastmodified, deleted 
     */

}
