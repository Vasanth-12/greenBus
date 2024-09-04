package com.learn.greenbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.service.BusDetailsService;


@RestController
public class BusController {

    @Autowired
    BusDetailsService busDetailsService;

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
}
