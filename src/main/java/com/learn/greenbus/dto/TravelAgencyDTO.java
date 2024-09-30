package com.learn.greenbus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TravelAgencyDTO {
    public String id;

    @NotEmpty(message="Name Should not be blank")
    @Pattern(regexp="\\w.*")
    public String agencyname;

    @Email(message="Not a valid E-Mail address")
    public String emailid;
    
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$", message="Password doesn't meets the constrain")
    public String password;
}
