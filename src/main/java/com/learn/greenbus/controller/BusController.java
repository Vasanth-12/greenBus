package com.learn.greenbus.controller;

import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.model.BusDetails;
import com.learn.greenbus.service.BusDetailsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BusController {

    @Autowired
    BusDetailsService busDetailsService;

    @PostMapping("agency/{id}/addbus")
    public ResponseEntity addBus(@PathVariable String id, @RequestBody BusDetails busDetails) {

        busDetails.setAgencyid(id);
        try {
            busDetails = busDetailsService.addBus(busDetails);
            return new ResponseEntity<>(busDetails, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("agency/{agencyId}/{busId}")
    public ResponseEntity deletebus(@PathVariable String agencyId, @PathVariable String busId) {
        try {
            busDetailsService.deleteBus(busId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("agency/{agencyId}/listbus")
    public ResponseEntity listBus(@PathVariable String agencyId) {
        try {
            List<BusDetails> busList = busDetailsService.listBus(agencyId);
            return new ResponseEntity<>(busList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
