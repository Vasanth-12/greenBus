package com.learn.greenbus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.greenbus.model.Journey;
import com.learn.greenbus.model.BookingDetails;
import com.learn.greenbus.repository.JourneyRepo;

@Service
public class JourneyService {

    @Autowired
    JourneyRepo journeyRepo;

    public Journey optJourney(Journey journey) {

        journey.setAvailableSeats(journey.busdetails.getSeatCount());
        for (String seatnumber:journey.busdetails.seatNumber) {
            /*
             * need to be autowired
             */
            BookingDetails seatObj = new BookingDetails();
            seatObj.setSeatNumber(seatnumber);
            seatObj.setBooked(false);

            System.out.println(seatObj);

            journey.seatDetails.put(seatnumber, seatObj);
        }
        journeyRepo.save(journey);

        return journey;
    }

    public Journey getJourneyDetail(String id) {
        return journeyRepo.findById(id).orElseThrow();
    }

    public synchronized boolean booking(String journeyId, BookingDetails bookingDetails) {

        Journey journey = journeyRepo.findById(journeyId).orElseThrow();
        String seatNumber = bookingDetails.seatNumber;
        if (!journey.seatDetails.get(seatNumber).booked) {
            try {
                journey.seatDetails.replace(seatNumber, bookingDetails);
                journey.availableSeats--;
                journeyRepo.save(journey);
                return true;
            }
            catch (Exception e) {
                throw e;
            }
        }
        else
            return false;

    }


}