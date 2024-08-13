package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.model.TravelAgency;
import com.learn.greenbus.repository.TravelAgencyRepo;

import lombok.Data;

@Data
@Service
public class TravelAgencyService {

    @Autowired
    TravelAgencyRepo repo;

    public TravelAgency agencyLogin(TravelAgency agency) {

        String agencyMailID = agency.agencyEmailID;
        String password = agency.password;

        TravelAgency res = repo.findByAgencyEmailID(agencyMailID);
        if (res.password.equals(password)) {
            return res;   
        }
        return null;
    }

    public TravelAgency agencySignup(TravelAgency agency) {
        System.out.println("Inside agencySignup: " + agency);
        repo.save(agency);
        return agency;
    }

}
