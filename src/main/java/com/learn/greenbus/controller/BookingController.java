package com.learn.greenbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.greenbus.dto.BookingDTO;
import com.learn.greenbus.service.BookingService;

import jakarta.validation.Valid;


@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity bookSeats(@Valid @RequestBody BookingDTO bookingDTO) {
        try {
            bookingService.book(bookingDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
