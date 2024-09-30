package com.learn.greenbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.dto.TravelAgencyDTO;
import com.learn.greenbus.model.BusDetails;
import com.learn.greenbus.service.TravelAgencyService;



@RestController
public class TravelAgencyController {

    @Autowired
    TravelAgencyService agencyService;

    @PostMapping("agency/login")   
    public ResponseEntity agencyLogin(@RequestBody TravelAgencyDTO agencyUser) {
        try {
            TravelAgencyDTO agency = agencyService.agencyLogin(agencyUser);
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

    @PostMapping("/agency/signup")
    public ResponseEntity agencySignup(@RequestBody TravelAgencyDTO agency) {
        try {
            agency = agencyService.agencySignup(agency);
            return new ResponseEntity<>(agency, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/agency/{id}/getbuslist")
    public ResponseEntity getAgencyBusList(@PathVariable String id) {
        try {
            List<BusDetails> busList = agencyService.getAgencyBusList                                                                                                                                                                                                                                               (id);
            return new ResponseEntity<>(busList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/agency/{id}/addbus")
    public ResponseEntity addBus(@PathVariable String id, @RequestBody BusDetails busDetails) {

        busDetails.setAgencyid(id);
        try {
            busDetails = agencyService.addBus(busDetails);
            return new ResponseEntity<>(busDetails, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
