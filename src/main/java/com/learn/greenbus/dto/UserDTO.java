package com.learn.greenbus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    public String id;
    public String username;
    public String emailid;
    public String mobilenumber;
    public String password;
}

