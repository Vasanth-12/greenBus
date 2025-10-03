package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.dto.BookingDTO;
import com.learn.greenbus.model.Booking;
import com.learn.greenbus.model.Journey;
import com.learn.greenbus.model.SeatInfo;
import com.learn.greenbus.repository.BookingRepo;
import com.learn.greenbus.repository.JourneyRepo;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    JourneyRepo journeyRepo;

    public boolean book(BookingDTO bookingDTO) {
        
        boolean allSeatsAvailable = true;
        String journeyId = bookingDTO.journeyId;
        Journey journey = journeyRepo.findById(journeyId).orElseThrow();
        for (SeatInfo obj : bookingDTO.seatInfo) {
            String  seatNumber = obj.seatNumber; 
            if (journey.seatDetails.get(seatNumber).booked) {
                allSeatsAvailable = false;
                break;
            }
            else {
                journey.seatDetails.replace(seatNumber,  obj);
                journey.seatDetails.get(seatNumber).setBooked(true);
                journey.availableSeats--;
            }
        }

        if (allSeatsAvailable) {
            Booking bookingDetails = Booking.builder()
                .journeyid(journeyId)
                .seatInfo(bookingDTO.seatInfo)
                .build();

            bookingRepo.save(bookingDetails);
            journeyRepo.save(journey);
            return true;
        }
        return false;
    }
}