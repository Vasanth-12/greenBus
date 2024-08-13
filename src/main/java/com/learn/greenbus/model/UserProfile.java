package com.learn.greenbus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "UserProfile")
public class UserProfile {

    @Id
    public String id; 
    public String username;
    public String emailid;
    public String mobilenumber;
    public String password;
}
