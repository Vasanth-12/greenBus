package com.learn.greenbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.model.BusDetails;
import com.learn.greenbus.model.TravelAgency;
import com.learn.greenbus.repository.TravelAgencyRepo;
import com.learn.greenbus.service.TravelAgencyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TravelAgencyController {

    @Autowired
    TravelAgencyService agencyService;

    @PostMapping("agency/login")   
    public ResponseEntity agencyLogin(@RequestBody TravelAgency agencyUser) {
        try {
            TravelAgency agency = agencyService.agencyLogin(agencyUser);
            if (agency != null) {
                return new ResponseEntity<>(agency, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("agency/signup")
    public ResponseEntity agencySignup(@RequestBody TravelAgency agency) {
        try {
            agency = agencyService.agencySignup(agency);
            return new ResponseEntity<>(agency, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

}
