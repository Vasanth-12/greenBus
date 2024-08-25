package com.learn.greenbus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    public String id;
    public String username;
    public String emailid;

}
