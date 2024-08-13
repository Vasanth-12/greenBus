package com.learn.greenbus.controller;

import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.model.BookingDetails;
import com.learn.greenbus.model.Journey;
import com.learn.greenbus.service.JourneyService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class JourneyController {

    @Autowired
    JourneyService journeyService;

    @PostMapping("agency/{agencyid}/optjourney")
    public ResponseEntity optJourney(@PathVariable String agencyid, @RequestBody Journey journey) {

        try {
            journeyService.optJourney(journey);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("journey/{journeyid}")
    public ResponseEntity getJourneyDetail(@PathVariable String journeyid) {

        try {
            Journey journeyDetails = journeyService.getJourneyDetail(journeyid);
            return new ResponseEntity<>(journeyDetails, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("journey/{journeyid}")
    public ResponseEntity booking(@PathVariable String journeyid, @RequestBody BookingDetails bookingDetails) {
        
        try {
            if (journeyService.booking(journeyid, bookingDetails)) {
                return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        }
        catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // List journey based on boarding point, destiny and date
    

}
